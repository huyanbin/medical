package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TPolicy;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 政策Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/policy")
public class TPolicyController extends BaseController
{
    private String prefix = "medical/policy";

    @Autowired
    private ITPolicyService tPolicyService;

    @GetMapping()
    public String policy()
    {
        return prefix + "/policy";
    }

    /**
     * 查询政策列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPolicy tPolicy)
    {
        startPage();
        List<TPolicy> list = tPolicyService.selectTPolicyList(tPolicy);
        return getDataTable(list);
    }


    /**
     * 新增政策
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存政策
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPolicy tPolicy)
    {
        return toAjax(tPolicyService.insertTPolicy(tPolicy));
    }

    /**
     * 修改政策
     */
    @GetMapping("/edit/{runyear}")
    public String edit(@PathVariable("runyear") String runyear, ModelMap mmap)
    {
        TPolicy tPolicy = tPolicyService.selectTPolicyById(runyear);
        mmap.put("tPolicy", tPolicy);
        return prefix + "/edit";
    }

    /**
     * 修改保存政策
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPolicy tPolicy)
    {
        return toAjax(tPolicyService.updateTPolicy(tPolicy));
    }

    /**
     * 删除政策
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPolicyService.deleteTPolicyByIds(ids));
    }
}
