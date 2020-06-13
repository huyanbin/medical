package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TInstitution;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 机构Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/institution")
public class TInstitutionController extends BaseController
{
    private String prefix = "medical/institution";

    @Autowired
    private ITInstitutionService tInstitutionService;

    @GetMapping()
    public String institution()
    {
        return prefix + "/institution";
    }

    /**
     * 查询机构列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TInstitution tInstitution)
    {
        startPage();
        List<TInstitution> list = tInstitutionService.selectTInstitutionList(tInstitution);
        return getDataTable(list);
    }


    /**
     * 新增机构
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存机构
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TInstitution tInstitution)
    {
        return toAjax(tInstitutionService.insertTInstitution(tInstitution));
    }

    /**
     * 修改机构
     */
    @GetMapping("/edit/{agencode}")
    public String edit(@PathVariable("agencode") String agencode, ModelMap mmap)
    {
        TInstitution tInstitution = tInstitutionService.selectTInstitutionById(agencode);
        mmap.put("tInstitution", tInstitution);
        return prefix + "/edit";
    }

    /**
     * 修改保存机构
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TInstitution tInstitution)
    {
        return toAjax(tInstitutionService.updateTInstitution(tInstitution));
    }

    /**
     * 删除机构
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tInstitutionService.deleteTInstitutionByIds(ids));
    }
}
