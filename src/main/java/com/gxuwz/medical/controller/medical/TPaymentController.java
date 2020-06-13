package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.controller.RedisUtil;
import com.gxuwz.medical.domain.TPayment;
import com.gxuwz.medical.domain.TPerson;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITPaymentService;
import com.gxuwz.medical.service.ITPersonService;
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
 * 付款Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/payment")
public class TPaymentController extends BaseController
{
    private String prefix = "medical/payment";

    @Autowired
    private ITPaymentService tPaymentService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ITPersonService itPersonService;


    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询付款列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPayment tPayment)
    {
        startPage();
        List<TPayment> list = tPaymentService.selectTPaymentList(tPayment);
        return getDataTable(list);
    }

    /**
     * 付款
     */
    @PostMapping("/paymentPerson")
    @ResponseBody
    public AjaxResult paymentPerson(String ids, String pay)
    {
        System.out.println(ids+pay);
        String amount = redisUtil.get("payperiodAmount").toString();
        String famicode = redisUtil.get("paymentFami").toString();
        String creator = redisUtil.get("userName").toString();
        TPerson tPerson = new TPerson();
        tPerson.setFamicode(famicode);
        List<TPerson> tPersonList = itPersonService.selectTPersonList(tPerson);
        for (TPerson t : tPersonList) {
            TPayment tPayment = new TPayment();
            tPayment.setPayno(Long.parseLong(UidCard.uidCard()));
            tPayment.setPerscode(t.getPerscode());
            String []sp = amount.split("\\.");
            tPayment.setPaycost(Long.parseLong(sp[0]));
            tPayment.setRunyear(Long.parseLong(DateUtils.getCurrentYear()));
            tPayment.setPaytime(DateUtils.getNowDate());
            tPayment.setCreator(creator);
            tPayment.setFamicode(famicode);
            tPaymentService.insertTPayment(tPayment);
        }

        redisUtil.del("payperiodAmount", "paymentFami", "paymentNum");

        return success("付款成功！");
    }

    /**
     * 新增付款
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存付款
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPayment tPayment)
    {
        return toAjax(tPaymentService.insertTPayment(tPayment));
    }

    /**
     * 修改付款
     */
    @GetMapping("/edit/{payno}")
    public String edit(@PathVariable("payno") Long payno, ModelMap mmap)
    {
        TPayment tPayment = tPaymentService.selectTPaymentById(payno);
        mmap.put("tPayment", tPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存付款
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPayment tPayment)
    {
        return toAjax(tPaymentService.updateTPayment(tPayment));
    }

    /**
     * 删除付款
     */

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPaymentService.deleteTPaymentByIds(ids));
    }
}
