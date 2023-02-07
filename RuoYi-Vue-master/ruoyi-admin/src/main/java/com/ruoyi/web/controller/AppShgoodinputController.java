package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AppShgoodinput;
import com.ruoyi.system.service.IAppShgoodinputService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品入库Controller
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@RestController
@RequestMapping("/system/shgoodinput")
public class AppShgoodinputController extends BaseController
{
    @Autowired
    private IAppShgoodinputService appShgoodinputService;

    /**
     * 查询商品入库列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppShgoodinput appShgoodinput)
    {
        startPage();
        List<AppShgoodinput> list = appShgoodinputService.selectAppShgoodinputList(appShgoodinput);
        return getDataTable(list);
    }

    /**
     * 导出商品入库列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:export')")
    @Log(title = "商品入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppShgoodinput appShgoodinput)
    {
        List<AppShgoodinput> list = appShgoodinputService.selectAppShgoodinputList(appShgoodinput);
        ExcelUtil<AppShgoodinput> util = new ExcelUtil<AppShgoodinput>(AppShgoodinput.class);
        util.exportExcel(response, list, "商品入库数据");
    }

    /**
     * 获取商品入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appShgoodinputService.selectAppShgoodinputById(id));
    }

    /**
     * 新增商品入库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:add')")
    @Log(title = "商品入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppShgoodinput appShgoodinput)
    {
        return toAjax(appShgoodinputService.insertAppShgoodinput(appShgoodinput));
    }

    /**
     * 修改商品入库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:edit')")
    @Log(title = "商品入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppShgoodinput appShgoodinput)
    {
        return toAjax(appShgoodinputService.updateAppShgoodinput(appShgoodinput));
    }

    /**
     * 删除商品入库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodinput:remove')")
    @Log(title = "商品入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appShgoodinputService.deleteAppShgoodinputByIds(ids));
    }
}
