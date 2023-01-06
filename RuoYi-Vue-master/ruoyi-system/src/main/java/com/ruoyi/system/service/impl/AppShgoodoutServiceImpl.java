package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppShgoodoutMapper;
import com.ruoyi.system.domain.AppShgoodout;
import com.ruoyi.system.service.IAppShgoodoutService;

/**
 * 商品出库Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-07
 */
@Service
public class AppShgoodoutServiceImpl implements IAppShgoodoutService 
{
    @Autowired
    private AppShgoodoutMapper appShgoodoutMapper;

    /**
     * 查询商品出库
     * 
     * @param id 商品出库主键
     * @return 商品出库
     */
    @Override
    public AppShgoodout selectAppShgoodoutById(Long id)
    {
        return appShgoodoutMapper.selectAppShgoodoutById(id);
    }

    /**
     * 查询商品出库列表
     * 
     * @param appShgoodout 商品出库
     * @return 商品出库
     */
    @Override
    public List<AppShgoodout> selectAppShgoodoutList(AppShgoodout appShgoodout)
    {
        return appShgoodoutMapper.selectAppShgoodoutList(appShgoodout);
    }

    /**
     * 新增商品出库
     * 
     * @param appShgoodout 商品出库
     * @return 结果
     */
    @Override
    public int insertAppShgoodout(AppShgoodout appShgoodout)
    {
        appShgoodout.setCreateTime(DateUtils.getNowDate());
        return appShgoodoutMapper.insertAppShgoodout(appShgoodout);
    }

    /**
     * 修改商品出库
     * 
     * @param appShgoodout 商品出库
     * @return 结果
     */
    @Override
    public int updateAppShgoodout(AppShgoodout appShgoodout)
    {
        appShgoodout.setUpdateTime(DateUtils.getNowDate());
        return appShgoodoutMapper.updateAppShgoodout(appShgoodout);
    }

    /**
     * 批量删除商品出库
     * 
     * @param ids 需要删除的商品出库主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodoutByIds(Long[] ids)
    {
        return appShgoodoutMapper.deleteAppShgoodoutByIds(ids);
    }

    /**
     * 删除商品出库信息
     * 
     * @param id 商品出库主键
     * @return 结果
     */
    @Override
    public int deleteAppShgoodoutById(Long id)
    {
        return appShgoodoutMapper.deleteAppShgoodoutById(id);
    }
}
