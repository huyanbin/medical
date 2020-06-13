package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.controller.RedisUtil;
import com.gxuwz.medical.domain.TChronicinfo;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITChronicinfoService;
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
 * 慢性信息Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/chronicinfo")
public class TChronicinfoController extends BaseController
{
    private String prefix = "medical/chronicinfo";

    @Autowired
    private ITChronicinfoService tChronicinfoService;

    @Autowired
    private RedisUtil redisUtil;


    @GetMapping()
    public String chronicinfo()
    {
        return prefix + "/chronicinfo";
    }

    /**
     * 查询慢性信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TChronicinfo tChronicinfo)
    {
        startPage();
        List<TChronicinfo> list = tChronicinfoService.selectTChronicinfoList(tChronicinfo);
        return getDataTable(list);
    }


    /**
     * 新增慢性信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存慢性信息
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TChronicinfo tChronicinfo)
    {
        String userName = redisUtil.get("userName").toString();
        tChronicinfo.setCreator(userName);
        tChronicinfo.setId("450"+UidCard.uidCard());
        return toAjax(tChronicinfoService.insertTChronicinfo(tChronicinfo));
    }

    /**
     * 修改慢性信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TChronicinfo tChronicinfo = tChronicinfoService.selectTChronicinfoById(id);
        mmap.put("tChronicinfo", tChronicinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存慢性信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TChronicinfo tChronicinfo)
    {
        return toAjax(tChronicinfoService.updateTChronicinfo(tChronicinfo));
    }

    /**
     * 删除慢性信息
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tChronicinfoService.deleteTChronicinfoByIds(ids));
    }
}
