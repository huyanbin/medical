package com.gxuwz.medical.controller.medical;

import java.math.BigDecimal;
import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.controller.RedisUtil;
import com.gxuwz.medical.domain.*;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.*;
import com.gxuwz.medical.utils.DateUtils;
import com.gxuwz.medical.utils.UidCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 报销Controller
 * 
 * @author ruoyi
 * @date 2020-06-06
 */
@Controller
@RequestMapping("/medical/reimburse")
public class ReimburseController extends BaseController
{
    private String prefix = "medical/reimburse";

    @Autowired
    private IReimburseService reimburseService;

    //档案表
    @Autowired
    private ITPersonService itPersonService;

    //参合登记
    @Autowired
    private ITPaymentService paymentService;

    //慢性病证
    @Autowired
    private ITChronicinfoService itChronicinfoService;

    //报销政策
    @Autowired
    private ITPolicyService itPolicyService;

    @Autowired
    private RedisUtil redisUtil;



    @GetMapping()
    public String reimburse()
    {
        return prefix + "/reimburse";
    }

    //按病种统计页面
    @GetMapping("/reimburseDisease")
    public String reimburseDisease() {
        return prefix + "/reimburseDisease";

    }

    //按行政区统计页面
    @GetMapping("/reimburseArea")
    public String reimburseArea() {
        return prefix + "/reimburseArea";

    }

    /**
     * 查询报销列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Reimburse reimburse)
    {
        startPage();
        if (reimburse.getIdCard() != null) {
            List<Reimburse> list = reimburseService.selectReimburseList(reimburse);
            if (list.size() == 0) {
                TPerson tper = new TPerson();
                tper.setCardId(reimburse.getIdCard());
                TPerson tPerson = itPersonService.selectTPersonByCardId(reimburse.getIdCard());
                if (tPerson != null) {
                    TPayment tpa = new TPayment();
                    tpa.setPerscode(tPerson.getPerscode());
                    List<TPayment>  tPayment = paymentService.selectTPaymentList(tpa);
                    if (tPayment != null) {
                        TChronicinfo tChronicinfo = new TChronicinfo();
                        tChronicinfo.setPerscode(tPayment.get(0).getPerscode());
                        List<TChronicinfo> tChronicinfoList = itChronicinfoService.selectTChronicinfoList(tChronicinfo);
                        if (tChronicinfoList != null) {
                            Reimburse reim = new Reimburse();
                            reim.setReiNo(UidCard.uidCard());
                            reim.setIdCard(reimburse.getIdCard());
                            reim.setChroNo(tPerson.getRuralCard());
                            reim.setCreaTime(DateUtils.getNowDate());
                            reim.setDiseaseName(tChronicinfoList.get(0).getIllcode());
                            reim.setStatus("0");
                            reimburseService.insertReimburse(reim);
                        }
                    }
                }

            }
        }
        List<Reimburse> list = reimburseService.selectReimburseList(reimburse);

        return getDataTable(list);
    }



    /**
     * 新增报销
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报销
     */

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Reimburse reimburse)
    {

        return toAjax(reimburseService.insertReimburse(reimburse));
    }

    /**
     * 修改报销
     */
    @GetMapping("/edit/{reiNo}")
    public String edit(@PathVariable("reiNo") String reiNo, ModelMap mmap)
    {
        Reimburse reimburse = reimburseService.selectReimburseById(reiNo);
        mmap.put("reimburse", reimburse);
        return prefix + "/edit";
    }

    /**
     * 修改保存报销
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Reimburse reimburse)
    {

        reimburse.setCreator(redisUtil.get("userName").toString());
        BigDecimal mon = new BigDecimal(0);
        //本年报销政策
        TPolicy tPolicy = itPolicyService.selectTPolicyById(DateUtils.getCurrentYear());

        //上一次报销的+历史报销的总合
        long alre = new Long(0);
        if (reimburse.getReiAlre() != null) {
             alre = reimburse.getReiAlre();
            if (reimburse.getReiNow() != null) {
                alre += reimburse.getReiNow();
            }
        }

        //已经报销金额
        reimburse.setReiAlre(alre);
        String st = reimburse.getCost().toString();
        BigDecimal do1 = BigDecimal.valueOf(Double.parseDouble(st));
        BigDecimal do2 = BigDecimal.valueOf(Double.parseDouble(tPolicy.getRemark()));
        double nows = do1.multiply(do2).doubleValue();
        long now = (long)nows;
        long rema = new Double(tPolicy.getMaxline()).longValue() - alre;
        if (now <= rema) {
            //本次可报销金额
            reimburse.setReiNow(now);
        }else if (rema > 0) {
            reimburse.setReiNow(rema);
        }else {
            reimburse.setReiNow(new Long(0));
        }

        //可报销金额
        reimburse.setReiRema(String.valueOf(rema));
        return toAjax(reimburseService.updateReimburse(reimburse));
    }

    /**
     * 报销
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        Reimburse reimburse = reimburseService.selectReimburseById(ids);
        long now = reimburse.getReiNow();
        long rema = Long.parseLong(reimburse.getReiRema());
        long alre = reimburse.getReiAlre();
        //Reimburse re = new Reimburse();
        reimburse.setReiNow(new Long(0));
        reimburse.setReiAlre(alre+now);
        reimburse.setReiRema(String.valueOf(rema - now));
        reimburse.setStatus("1");
        reimburse.setCost(new Long(0));
        reimburse.setInvoice("0");
        reimburse.setUpdateTime(DateUtils.getNowDate());
        reimburseService.updateReimburse(reimburse);
        return success("报销成功！");
    }
}
