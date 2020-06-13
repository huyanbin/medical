package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TRecordfree;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITRecordfreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 记录Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/recordfree")
public class TRecordfreeController extends BaseController
{
    private String prefix = "medical/recordfree";

    @Autowired
    private ITRecordfreeService tRecordfreeService;

    @GetMapping()
    public String recordfree()
    {
        return prefix + "/recordfree";
    }

    /**
     * 查询记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TRecordfree tRecordfree)
    {
        startPage();
        List<TRecordfree> list = tRecordfreeService.selectTRecordfreeList(tRecordfree);
        return getDataTable(list);
    }


    /**
     * 新增记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存记录
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TRecordfree tRecordfree)
    {
        return toAjax(tRecordfreeService.insertTRecordfree(tRecordfree));
    }

    /**
     * 修改记录
     */
    @GetMapping("/edit/{perscode}")
    public String edit(@PathVariable("perscode") String perscode, ModelMap mmap)
    {
        TRecordfree tRecordfree = tRecordfreeService.selectTRecordfreeById(perscode);
        mmap.put("tRecordfree", tRecordfree);
        return prefix + "/edit";
    }

    /**
     * 修改保存记录
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TRecordfree tRecordfree)
    {
        return toAjax(tRecordfreeService.updateTRecordfree(tRecordfree));
    }

    /**
     * 删除记录
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tRecordfreeService.deleteTRecordfreeByIds(ids));
    }
}
