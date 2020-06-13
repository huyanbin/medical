package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TPayperiod;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITPayperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 期限Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/payperiod")
public class TPayperiodController extends BaseController
{
    private String prefix = "medical/payperiod";

    @Autowired
    private ITPayperiodService tPayperiodService;

    @GetMapping()
    public String payperiod()
    {
        return prefix + "/payperiod";
    }

    /**
     * 查询期限列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPayperiod tPayperiod)
    {
        startPage();
        List<TPayperiod> list = tPayperiodService.selectTPayperiodList(tPayperiod);
        return getDataTable(list);
    }



    /**
     * 新增期限
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存期限
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPayperiod tPayperiod)
    {
        return toAjax(tPayperiodService.insertTPayperiod(tPayperiod));
    }

    /**
     * 修改期限
     */
    @GetMapping("/edit/{runyear}")
    public String edit(@PathVariable("runyear") Long runyear, ModelMap mmap)
    {
        TPayperiod tPayperiod = tPayperiodService.selectTPayperiodById(runyear);
        mmap.put("tPayperiod", tPayperiod);
        return prefix + "/edit";
    }

    /**
     * 修改保存期限
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPayperiod tPayperiod)
    {
        return toAjax(tPayperiodService.updateTPayperiod(tPayperiod));
    }

    /**
     * 删除期限
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPayperiodService.deleteTPayperiodByIds(ids));
    }
}
