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
import com.ruoyi.system.domain.AppShuser;
import com.ruoyi.system.service.IAppShuserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2022-12-24
 */
@RestController
@RequestMapping("/system/shuser")
public class AppShuserController extends BaseController
{
    @Autowired
    private IAppShuserService appShuserService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppShuser appShuser)
    {
        startPage();
        List<AppShuser> list = appShuserService.selectAppShuserList(appShuser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppShuser appShuser)
    {
        List<AppShuser> list = appShuserService.selectAppShuserList(appShuser);
        ExcelUtil<AppShuser> util = new ExcelUtil<AppShuser>(AppShuser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appShuserService.selectAppShuserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppShuser appShuser)
    {
        return toAjax(appShuserService.insertAppShuser(appShuser));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppShuser appShuser)
    {
        return toAjax(appShuserService.updateAppShuser(appShuser));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:shuser:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appShuserService.deleteAppShuserByIds(ids));
    }
}
