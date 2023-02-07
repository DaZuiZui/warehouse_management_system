package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.AppShgood;
import com.ruoyi.system.domain.AppShgoodout;
import com.ruoyi.system.mapper.AppShgoodoutMapper;
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
    @Autowired
    private AppShgoodoutMapper appShgoodoutMapper;
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
        String name = appShgoodinput.getName();
        AppShgood appShgood = appShgoodinputMapper.selectAppShgoodByName(name);
        if (appShgood == null){
            //添加库存
            appShgoodinputMapper.addgoods(name,appShgoodinput.getNumbers(),new Date());
        }else{
            //更新库存
            appShgoodoutMapper.outgoods(name,appShgoodinput.getNumbers());
        }

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
        //System.err.println(appShgoodout.getNumbers()+"asdasd"+appShgoodout.getId()+"and"+appShgoodout.getName());
        //获取仓库商品数量
        AppShgood appShgood = appShgoodoutMapper.querygoods(appShgoodinput.getName());
        //获取当前数据的个数
        AppShgoodout appShgoodout1 = appShgoodinputMapper.querygoodsByid(appShgoodinput.getId());
        //如果当前修改的数据小于之前的数量
        if (appShgoodout1.getNumbers() > appShgoodinput.getNumbers()){
            Long tmp = appShgoodinput.getNumbers() - appShgoodout1.getNumbers();
            if (tmp > appShgood.getNumbers()){
                return 0;
            }
            //    Long tmp = appShgoodout1.getNumbers() - appShgoodinput.getNumbers();
            // System.err.println("??");
            appShgoodoutMapper.outgoods(appShgoodinput.getName(), tmp);
        }else{
            Long tmp = appShgoodout1.getNumbers() - appShgoodinput.getNumbers();
            appShgoodoutMapper.outgoods(appShgoodinput.getName(), -tmp);
        }

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
