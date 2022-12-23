package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AppShuser;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2022-12-14
 */
public interface IAppShuserService 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public AppShuser selectAppShuserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param appShuser 用户
     * @return 用户集合
     */
    public List<AppShuser> selectAppShuserList(AppShuser appShuser);

    /**
     * 新增用户
     * 
     * @param appShuser 用户
     * @return 结果
     */
    public int insertAppShuser(AppShuser appShuser);

    /**
     * 修改用户
     * 
     * @param appShuser 用户
     * @return 结果
     */
    public int updateAppShuser(AppShuser appShuser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteAppShuserByIds(Long[] ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteAppShuserById(Long id);
}
