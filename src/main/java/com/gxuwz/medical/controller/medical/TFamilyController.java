package com.gxuwz.medical.controller.medical;

import java.util.List;

import com.gxuwz.medical.controller.BaseController;
import com.gxuwz.medical.controller.RedisUtil;
import com.gxuwz.medical.domain.TFamily;
import com.gxuwz.medical.domain.VO.AjaxResult;
import com.gxuwz.medical.domain.page.TableDataInfo;
import com.gxuwz.medical.service.ITFamilyService;
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
 * 家庭档案Controller
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/medical/family")
public class TFamilyController extends BaseController
{
    private String prefix = "medical/family";

    @Autowired
    private ITFamilyService tFamilyService;

    @Autowired
    private RedisUtil redisUtil;


    /**参合登记*/
    @GetMapping("/person")
    public String familyPerson() {
        return "medical/payment/familyPayment";
    }

    @GetMapping()
    public String family()
    {
        return prefix + "/family";
    }


    /**详情*/
    @GetMapping("/details/{famicode}")
    public String details(@PathVariable("famicode")String famicode,ModelMap map) {

        redisUtil.set("famicode", famicode, 60);

        return "medical/person/person";
    }

    //@GetMapping("/offer")
    public void offer() {

        redisUtil.del("famicode");

    }



    /**
     * 查询家庭档案列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TFamily tFamily)
    {
        if (redisUtil.hasKey("famicode")){
            offer();
        }
        startPage();
        List<TFamily> list = tFamilyService.selectTFamilyList(tFamily);
        return getDataTable(list);
    }



    /**
     * 新增家庭档案
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("userId", redisUtil.get("userId").toString());
        modelMap.put("userName", redisUtil.get("userName").toString());
        return prefix + "/add";
    }

    /**
     * 新增保存家庭档案
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TFamily tFamily)
    {
        //tFamily.setCreator(redisUtil.get("userId").toString());
        tFamily.setFamicode("450"+UidCard.uidCard());
        return toAjax(tFamilyService.insertTFamily(tFamily));
    }

    /**
     * 修改家庭档案
     */
    @GetMapping("/edit/{famicode}")
    public String edit(@PathVariable("famicode") String famicode, ModelMap mmap)
    {
        TFamily tFamily = tFamilyService.selectTFamilyById(famicode);
        mmap.put("tFamily", tFamily);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭档案
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TFamily tFamily)
    {
        return toAjax(tFamilyService.updateTFamily(tFamily));
    }

    /**
     * 删除家庭档案
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tFamilyService.deleteTFamilyByIds(ids));
    }
}
