package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppShuserMapper;
import com.ruoyi.system.domain.AppShuser;
import com.ruoyi.system.service.IAppShuserService;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-24
 */
@Service
public class AppShuserServiceImpl implements IAppShuserService 
{
    @Autowired
    private AppShuserMapper appShuserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public AppShuser selectAppShuserById(Long id)
    {
        return appShuserMapper.selectAppShuserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param appShuser 用户
     * @return 用户
     */
    @Override
    public List<AppShuser> selectAppShuserList(AppShuser appShuser)
    {
        return appShuserMapper.selectAppShuserList(appShuser);
    }

    /**
     * 新增用户
     * 
     * @param appShuser 用户
     * @return 结果
     */
    @Override
    public int insertAppShuser(AppShuser appShuser)
    {
        appShuser.setCreateTime(DateUtils.getNowDate());
        return appShuserMapper.insertAppShuser(appShuser);
    }

    /**
     * 修改用户
     * 
     * @param appShuser 用户
     * @return 结果
     */
    @Override
    public int updateAppShuser(AppShuser appShuser)
    {
        appShuser.setUpdateTime(DateUtils.getNowDate());
        return appShuserMapper.updateAppShuser(appShuser);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteAppShuserByIds(Long[] ids)
    {
        return appShuserMapper.deleteAppShuserByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteAppShuserById(Long id)
    {
        return appShuserMapper.deleteAppShuserById(id);
    }
}
