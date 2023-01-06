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
import com.ruoyi.system.domain.AppShgoodout;
import com.ruoyi.system.service.IAppShgoodoutService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品出库Controller
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@RestController
@RequestMapping("/system/shgoodout")
public class AppShgoodoutController extends BaseController
{
    @Autowired
    private IAppShgoodoutService appShgoodoutService;

    /**
     * 查询商品出库列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppShgoodout appShgoodout)
    {
        startPage();
        List<AppShgoodout> list = appShgoodoutService.selectAppShgoodoutList(appShgoodout);
        return getDataTable(list);
    }

    /**
     * 导出商品出库列表
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:export')")
    @Log(title = "商品出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppShgoodout appShgoodout)
    {
        List<AppShgoodout> list = appShgoodoutService.selectAppShgoodoutList(appShgoodout);
        ExcelUtil<AppShgoodout> util = new ExcelUtil<AppShgoodout>(AppShgoodout.class);
        util.exportExcel(response, list, "商品出库数据");
    }

    /**
     * 获取商品出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appShgoodoutService.selectAppShgoodoutById(id));
    }

    /**
     * 新增商品出库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:add')")
    @Log(title = "商品出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppShgoodout appShgoodout)
    {
        return toAjax(appShgoodoutService.insertAppShgoodout(appShgoodout));
    }

    /**
     * 修改商品出库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:edit')")
    @Log(title = "商品出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppShgoodout appShgoodout)
    {
        return toAjax(appShgoodoutService.updateAppShgoodout(appShgoodout));
    }

    /**
     * 删除商品出库
     */
    @PreAuthorize("@ss.hasPermi('system:shgoodout:remove')")
    @Log(title = "商品出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appShgoodoutService.deleteAppShgoodoutByIds(ids));
    }
}
