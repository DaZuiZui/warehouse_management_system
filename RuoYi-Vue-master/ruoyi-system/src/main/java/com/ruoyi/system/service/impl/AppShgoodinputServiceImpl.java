package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppShgoodinputMapper;
import com.ruoyi.system.domain.AppShgoodinput;
import com.ruoyi.system.service.IAppShgoodinputService;

/**
 * 商品入库Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
@Service
public class AppShgoodinputServiceImpl implements IAppShgoodinputService 
{
    @Autowired
    private AppShgoodinputMapper appShgoodinputMapper;

    /**
     * 查询商品入库
     * 
     * @param id 商品入库主键
     * @return 商品入库
     */
    @Override
    public AppShgoodinput selectAppShgoodinputById(Long id)
    {
        return appShgoodinputMapper.selectAppShgoodinputById(id);
    }

    /**
     * 查询商品入库列表
     * 
     * @param appShgoodinput 商品入库
     * @return 商品入库
     */
    @Override
    public List<AppShgoodinput> selectAppShgoodinputList(AppShgoodinput appShgoodinput)
    {
        return appShgoodinputMapper.selectAppShgoodinputList(appShgoodinput);
    }

    /**
     * 新增商品入库
     * 
     * @param appShgoodinput 商品入库
     * @return 结果
     */
    @Override
    public int insertAppShgoodinput(AppShgoodinput appShgoodinput)
    {
        appShgoodinput.setCreateTime(DateUtils.getNowDate());
        return appShgoodinputMapper.insertAppShgoodinput(appShgoodinput);
    }

    /**
     * 修改商品入库
     * 
     * @param appShgoodinput 商品入库
     * @return 结果
     */
    @Override
    public int updateAppShgoodinput(AppShgoodinput appShgoodinput)
    {
        appShgoodinput.setUpdateTime(DateUtils.getNowDate());
        return appShgoodinputMapper.updateAppShgoodinput(appShgoodinput);
    }

    /**
     * 批量删除商品入库
     * 
     * @param ids 需要删除的商品入库主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodinputByIds(Long[] ids)
    {
        return appShgoodinputMapper.deleteAppShgoodinputByIds(ids);
    }

    /**
     * 删除商品入库信息
     * 
     * @param id 商品入库主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodinputById(Long id)
    {
        return appShgoodinputMapper.deleteAppShgoodinputById(id);
    }
}
