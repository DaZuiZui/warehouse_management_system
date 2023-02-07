package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppShgoodMapper;
import com.ruoyi.system.domain.AppShgood;
import com.ruoyi.system.service.IAppShgoodService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class AppShgoodServiceImpl implements IAppShgoodService 
{
    @Autowired
    private AppShgoodMapper appShgoodMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public AppShgood selectAppShgoodById(Long id)
    {
        return appShgoodMapper.selectAppShgoodById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param appShgood 商品
     * @return 商品
     */
    @Override
    public List<AppShgood> selectAppShgoodList(AppShgood appShgood)
    {
        return appShgoodMapper.selectAppShgoodList(appShgood);
    }

    /**
     * 新增商品
     * 
     * @param appShgood 商品
     * @return 结果
     */
    @Override
    public int insertAppShgood(AppShgood appShgood)
    {
        appShgood.setCreateTime(DateUtils.getNowDate());
        return appShgoodMapper.insertAppShgood(appShgood);
    }

    /**
     * 修改商品
     * 
     * @param appShgood 商品
     * @return 结果
     */
    @Override
    public int updateAppShgood(AppShgood appShgood)
    {
        appShgood.setUpdateTime(DateUtils.getNowDate());
        return appShgoodMapper.updateAppShgood(appShgood);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodByIds(Long[] ids)
    {
        return appShgoodMapper.deleteAppShgoodByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodById(Long id)
    {
        return appShgoodMapper.deleteAppShgoodById(id);
    }
}
