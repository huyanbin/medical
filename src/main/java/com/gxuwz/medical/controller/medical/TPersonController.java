package com.gxuwz.medical.controller.medical;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.controller.RedisUtil;
import com.gxuwz.medical.domain.TPayment;
import com.gxuwz.medical.domain.TPayperiod;
import com.gxuwz.medical.domain.TPerson;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITFamilyService;
import com.gxuwz.medical.service.ITPaymentService;
import com.gxuwz.medical.service.ITPayperiodService;
import com.gxuwz.medical.service.ITPersonService;
import com.gxuwz.medical.utils.Convert;
import com.gxuwz.medical.utils.DateUtils;
import com.gxuwz.medical.utils.UidCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 人Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/person")
public class TPersonController extends BaseController
{
    private String prefix = "medical/person";

    @Autowired
    private ITPersonService tPersonService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ITFamilyService tFamilyService;

    @Autowired
    private ITPaymentService itPaymentService;

    @Autowired
    private ITPayperiodService payperiodService;


    @GetMapping()
    public String person()
    {
        return prefix + "/person";
    }


    /**
     * 详情--查询人列表
     */
    @PostMapping("/details/list")
    @ResponseBody
    public TableDataInfo detailsList(TPerson tPerson)
    {
        if (redisUtil.hasKey("famicode")){
            if (redisUtil.get("famicode") != null) {
                tPerson.setFamicode(redisUtil.get("famicode").toString());
            }
        }

        startPage();
        List<TPerson> list = tPersonService.selectTPersonList(tPerson);
        return getDataTable(list);
    }


    /**
     * 查询人档案列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPerson tPerson, Model model)
    {
        if (redisUtil.hasKey("famicode")){
            String famicode = redisUtil.get("famicode").toString();
            if ( famicode != null) {
                tPerson.setFamicode(famicode);
                model.addAttribute("family", true);
                System.out.println("00000000000"+famicode);
            }
        }
        startPage();
        List<TPerson> list = tPersonService.selectTPersonList(tPerson);
        //redisUtil.del("famicode");
        return getDataTable(list);
    }

    /**
     * 判断身份证是否存在*/
    public boolean repeatCard(String card) {
        List<TPerson> tPersonList = tPersonService.selectTPersonList(new TPerson());
        return tPersonList.contains(card);
    }

    /**
     * 新增人
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        Object famicode = redisUtil.get("famicode");

        if ( famicode != null) {
            modelMap.put("famicode", famicode);
            modelMap.put("persname", tFamilyService.selectTFamilyById(famicode.toString()).getHouseName());
        }
        return prefix + "/add";
    }

    /**
     * 添加成员
     * */
    @GetMapping("/addPerson/{personId}")
    public String addPerson(@PathVariable("personId") String personId) {
        redisUtil.set("famiCodes", personId,30);
        return prefix + "/add";
    }



    /**
     * 新增保存人
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPerson tPerson)
    {
        if (repeatCard(tPerson.getCardId()) == false) {
            return error("身份证已经存在");
        }

        TPerson tpe = new TPerson();
        if (redisUtil.hasKey("famiCodes")) {
            if (redisUtil.get("famiCodes").toString() == null) {
                return success("请重新选择一个家庭档案添加！");
            }else {
                tpe.setFamicode(redisUtil.get("famiCodes").toString());
                tpe.setRelation("0");
                List<TPerson> tPeople = tPersonService.selectTPersonList(tpe);
                if (tPeople.size() > 1) {
                        return error("只能有一个户主");
                }

                tPerson.setFamicode(redisUtil.get("famiCodes").toString());
                redisUtil.del("famiCodes");
            }
        }

        if (redisUtil.hasKey("famicode")) {
                if (redisUtil.get("famicode") == null) {
                    return error("请先创建家庭档案！");
                }else {
                    tpe.setFamicode(redisUtil.get("famicode").toString());
                    tpe.setRelation("0");
                    List<TPerson> tPeople = tPersonService.selectTPersonList(tpe);
                    if (tPeople.size() > 1) {
                        return error("只能有一个户主");
                    }
                    tPerson.setFamicode(redisUtil.get("famicode").toString());
                    redisUtil.del("famicode");
                }
            }

        tPerson.setPerscode("405"+UidCard.uidCard());

        return toAjax(tPersonService.insertTPerson(tPerson));
    }

    /**
     * 进入缴费
     */
    @GetMapping("/paymentList/{famicode}")
    public String paymentList(@PathVariable("famicode") String famicode, ModelMap mmap)
    {

        redisUtil.set("paymentFami",famicode, 60*5);

        return  "medical/payment/personPayment";
    }

    /**未缴费的成员列表*/
    @PostMapping("/paymentList")
    @ResponseBody
    public TableDataInfo paymentList() {

        Object famicode = redisUtil.get("paymentFami");
        TPayment tp = new TPayment();
        tp.setFamicode(famicode!=null?famicode.toString():null);
        //获取当前你年份，该家庭的全部成员
        tp.setRunyear(Long.parseLong(DateUtils.getCurrentYear()));
        List<TPayment> tPaymentList = itPaymentService.selectTPaymentList(tp);
        TPerson tPerson = new TPerson();
        List<TPerson> tPersonLists = new ArrayList<>();
        tPerson.setFamicode(famicode!=null?famicode.toString():null);
        List<TPerson> tPersonList = tPersonService.selectTPersonList(tPerson);
        for (TPerson t : tPersonList) {
            for (TPayment tm : tPaymentList) {
                if ( ! t.getPerscode().equals(tm.getPerscode())) {
                    tPersonLists.add(t);
                }
            }
        }
        redisUtil.set("paymentNum",tPersonLists.size(), 60*5);
        return getDataTable(tPersonLists);
    }

    /**
     * 开始缴费
     * */
    @GetMapping("/editSavePayment/{ids}")
    public String editSavePayment(@PathVariable("ids") String ids, ModelMap modelMap) {

        String date = DateUtils.getCurrentYear();
        TPayperiod payperiod = payperiodService.selectTPayperiodById(Long.parseLong(date));
        Long payl = Long.parseLong(redisUtil.get("paymentNum").toString());
        redisUtil.set("payperiodAmount",payperiod.getAmount());
        BigDecimal pay =  BigDecimal.valueOf(payl).multiply(BigDecimal.valueOf(payperiod.getAmount()));
        modelMap.put("ids", ids);
        modelMap.put("pay", pay);
        return "medical/payment/scanCode";
    }


    /**
     * 进入家庭登记列表
     */
    @PostMapping("/personList")
    @ResponseBody
    public TableDataInfo personList(TPerson tPerson, Model model)
    {
        startPage();
        List<TPerson> list = tPersonService.selectTPersonList(tPerson);
        //redisUtil.del("famicode");
        return getDataTable(list);
    }

    /**
     * 修改人
     */
    @GetMapping("/edit/{perscode}")
    public String edit(@PathVariable("perscode") String perscode, ModelMap mmap)
    {

        TPerson tPerson = tPersonService.selectTPersonById(perscode);
        mmap.put("tPerson", tPerson);
        return prefix + "/edit";
    }

    /**
     * 修改保存人
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPerson tPerson)
    {
        return toAjax(tPersonService.updateTPerson(tPerson));
    }

    /**
     * 删除人
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPersonService.deleteTPersonByIds(ids));
    }
}
