package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.AppShgood;
import com.ruoyi.system.domain.AppShgoodout;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 商品出库Mapper接口
 *
 * @author ruoyi
 * @date 2023-01-07
 */
public interface AppShgoodoutMapper
{
    @Select("select * from app_shgoodout where id = #{id} limit 1")
    public AppShgoodout querygoodsByid(@Param("id")Long id);

    @Update("update app_shgood set numbers = numbers + #{num} where name = #{name}")
    public Long outgoods(@Param("name")String name,@Param("num")Long num);

    @Select("select * from app_shgood where name = #{name} limit 1")
    public AppShgood querygoods(@Param("name")String name);
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
     * 删除商品出库
     *
     * @param id 商品出库主键
     * @return 结果
     */
    public int deleteAppShgoodoutById(Long id);

    /**
     * 批量删除商品出库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppShgoodoutByIds(Long[] ids);
}
