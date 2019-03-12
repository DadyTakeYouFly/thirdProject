package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInventoryOrderService {

    //获取所有
    List<SysInventoryOrder> selectAll(String page,String limit,String goodsId);

    //根据id获取
    SysInventoryOrder selectByPrimaryKey(String id);

    //增加
    SysInventoryOrder insert(String id,Integer goodsType,String goodsId,String goodsNumber,
                             String goodsDescribe);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id,Integer goodsType,String goodsId,String goodsNumber,
                   String goodsDescribe);

    //获取所有个数
    int countGetAll(String goodsId);

    //获取货品下拉框
    List<SysInventoryOrder> getFirstClassListGoods();

}
