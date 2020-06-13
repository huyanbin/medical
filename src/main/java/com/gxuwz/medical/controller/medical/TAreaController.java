package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.domain.TArea;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 行政区域信息Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/area")
public class TAreaController extends BaseController
{
    private String prefix = "medical/area";

    @Autowired
    private ITAreaService tAreaService;

    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询行政区域信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TArea tArea)
    {
        startPage();
        List<TArea> list = tAreaService.selectTAreaList(tArea);
        return getDataTable(list);
    }


    /**
     * 新增行政区域信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存行政区域信息
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TArea tArea)
    {
        return toAjax(tAreaService.insertTArea(tArea));
    }

    /**
     * 修改行政区域信息
     */
    @GetMapping("/edit/{areacode}")
    public String edit(@PathVariable("areacode") String areacode, ModelMap mmap)
    {
        TArea tArea = tAreaService.selectTAreaById(areacode);
        mmap.put("tArea", tArea);
        return prefix + "/edit";
    }

    /**
     * 修改保存行政区域信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TArea tArea)
    {
        return toAjax(tAreaService.updateTArea(tArea));
    }

    /**
     * 删除行政区域信息
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAreaService.deleteTAreaByIds(ids));
    }
}
