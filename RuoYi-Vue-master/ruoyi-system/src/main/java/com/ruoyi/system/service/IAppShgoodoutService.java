package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AppShgoodout;

/**
 * 商品出库Service接口
 *
 * @author ruoyi
 * @date 2023-01-07
 */
public interface IAppShgoodoutService
{
    /**
     * 查询商品出库
     *
     * @param id 商品出库主键
     * @return 商品出库
     */
    public AppShgoodout selectAppShgoodoutById(Long id);

    /**
     * 查询商品出库列表
     *
     * @param appShgoodout 商品出库
     * @return 商品出库集合
     */
    public List<AppShgoodout> selectAppShgoodoutList(AppShgoodout appShgoodout);

    /**
     * 新增商品出库
     *
     * @param appShgoodout 商品出库
     * @return 结果
     */
    public int insertAppShgoodout(AppShgoodout appShgoodout);

    /**
     * 修改商品出库
     *
     * @param appShgoodout 商品出库
     * @return 结果
     */
    public int updateAppShgoodout(AppShgoodout appShgoodout);

    /**
     * 批量删除商品出库
     *
     * @param ids 需要删除的商品出库主键集合
     * @return 结果
     */
    public int deleteAppShgoodoutByIds(Long[] ids);

    /**
     * 删除商品出库信息
     *
     * @param id 商品出库主键
     * @return 结果
     */
    public int deleteAppShgoodoutById(Long id);
}
