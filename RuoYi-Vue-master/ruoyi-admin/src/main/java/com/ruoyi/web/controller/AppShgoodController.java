package com.ruoyi.web.controller;

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
import com.ruoyi.system.domain.AppShgood;
import com.ruoyi.system.service.IAppShgoodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/system/shgood")
public class AppShgoodController extends BaseController
{
    @Autowired
    private IAppShgoodService appShgoodService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppShgood appShgood)
    {
        startPage();
        List<AppShgood> list = appShgoodService.selectAppShgoodList(appShgood);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppShgood appShgood)
    {
        List<AppShgood> list = appShgoodService.selectAppShgoodList(appShgood);
        ExcelUtil<AppShgood> util = new ExcelUtil<AppShgood>(AppShgood.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appShgoodService.selectAppShgoodById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppShgood appShgood)
    {
        return toAjax(appShgoodService.insertAppShgood(appShgood));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppShgood appShgood)
    {
        return toAjax(appShgoodService.updateAppShgood(appShgood));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('system:shgood:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appShgoodService.deleteAppShgoodByIds(ids));
    }
}
