package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TChronicdis;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITChronicdisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 慢性病Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/chronicdis")
public class TChronicdisController extends BaseController
{
    private String prefix = "medical/chronicdis";

    @Autowired
    private ITChronicdisService tChronicdisService;

    @GetMapping()
    public String chronicdis()
    {
        return prefix + "/chronicdis";
    }

    /**
     * 查询慢性病列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TChronicdis tChronicdis)
    {
        startPage();
        List<TChronicdis> list = tChronicdisService.selectTChronicdisList(tChronicdis);
        return getDataTable(list);
    }


    /**
     * 新增慢性病
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存慢性病
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TChronicdis tChronicdis)
    {
        return toAjax(tChronicdisService.insertTChronicdis(tChronicdis));
    }

    /**
     * 修改慢性病
     */
    @GetMapping("/edit/{illcode}")
    public String edit(@PathVariable("illcode") String illcode, ModelMap mmap)
    {
        TChronicdis tChronicdis = tChronicdisService.selectTChronicdisById(illcode);
        mmap.put("tChronicdis", tChronicdis);
        return prefix + "/edit";
    }

    /**
     * 修改保存慢性病
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TChronicdis tChronicdis)
    {
        return toAjax(tChronicdisService.updateTChronicdis(tChronicdis));
    }

    /**
     * 删除慢性病
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tChronicdisService.deleteTChronicdisByIds(ids));
    }
}
