package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.AppShgood;
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
        System.out.println(appShgoodout);
        //查看此商品是否存在
        AppShgood querygoods = appShgoodoutMapper.querygoods(appShgoodout.getName());
        if (querygoods == null){
            return 0;
        }
        //查看容量是否够
        if (querygoods.getNumbers() < appShgoodout.getNumbers()){
            return 0;
        }
        //商品库存减少
        appShgoodoutMapper.outgoods(appShgoodout.getName(), -appShgoodout.getNumbers());

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
        System.err.println(appShgoodout.getNumbers()+"asdasd"+appShgoodout.getId()+"and"+appShgoodout.getName());
        AppShgood appShgood = appShgoodoutMapper.querygoods(appShgoodout.getName());
        AppShgoodout appShgoodout1 = appShgoodoutMapper.querygoodsByid(appShgoodout.getId());
        if (appShgoodout1.getNumbers() > appShgoodout.getNumbers()){
            Long tmp = appShgoodout1.getNumbers() - appShgoodout.getNumbers();
            // System.err.println("??");
            appShgoodoutMapper.outgoods(appShgoodout.getName(), tmp);
        }else{
            Long tmp = appShgoodout.getNumbers() - appShgoodout1.getNumbers();
            if (tmp > appShgood.getNumbers()){
                return 0;
            }
            appShgoodoutMapper.outgoods(appShgoodout.getName(), -tmp);
        }

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
