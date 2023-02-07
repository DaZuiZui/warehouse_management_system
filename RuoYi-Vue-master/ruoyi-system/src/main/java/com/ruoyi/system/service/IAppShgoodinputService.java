package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AppShgoodinput;

/**
 * 商品入库Service接口
 * 
 * @author ruoyi
 * @date 2023-02-07
 */
public interface IAppShgoodinputService 
{
    /**
     * 查询商品入库
     * 
     * @param id 商品入库主键
     * @return 商品入库
     */
    public AppShgoodinput selectAppShgoodinputById(Long id);

    /**
     * 查询商品入库列表
     * 
     * @param appShgoodinput 商品入库
     * @return 商品入库集合
     */
    public List<AppShgoodinput> selectAppShgoodinputList(AppShgoodinput appShgoodinput);

    /**
     * 新增商品入库
     * 
     * @param appShgoodinput 商品入库
     * @return 结果
     */
    public int insertAppShgoodinput(AppShgoodinput appShgoodinput);

    /**
     * 修改商品入库
     * 
     * @param appShgoodinput 商品入库
     * @return 结果
     */
    public int updateAppShgoodinput(AppShgoodinput appShgoodinput);

    /**
     * 批量删除商品入库
     * 
     * @param ids 需要删除的商品入库主键集合
     * @return 结果
     */
    public int deleteAppShgoodinputByIds(Long[] ids);

    /**
     * 删除商品入库信息
     * 
     * @param id 商品入库主键
     * @return 结果
     */
    public int deleteAppShgoodinputById(Long id);
}
