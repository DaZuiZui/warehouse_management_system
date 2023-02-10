package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AppShgood;

/**
 * 商品Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface AppShgoodMapper 
{
    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    public AppShgood selectAppShgoodById(Long id);

    /**
     * 查询商品列表
     * 
     * @param appShgood 商品
     * @return 商品集合
     */
    public List<AppShgood> selectAppShgoodList(AppShgood appShgood);

    /**
     * 新增商品
     * 
     * @param appShgood 商品
     * @return 结果
     */
    public int insertAppShgood(AppShgood appShgood);

    /**
     * 修改商品
     * 
     * @param appShgood 商品
     * @return 结果
     */
    public int updateAppShgood(AppShgood appShgood);

    /**
     * 删除商品
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteAppShgoodById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppShgoodByIds(Long[] ids);
}
