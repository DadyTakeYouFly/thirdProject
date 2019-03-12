package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInventoryOrderMapper {

    //获取所有
    List<SysInventoryOrder> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("goodsId") String goodsId);

    //根据id查询
    SysInventoryOrder selectByPrimaryKey(String id);

    //增加
    int insert(SysInventoryOrder record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(SysInventoryOrder record);

    //获取所有个数
    int countGetAll(@Param("goodsId") String goodsId);

    //获取货品名称下拉框
    List<SysInventoryOrder> getFirstClassListGoods();
}
