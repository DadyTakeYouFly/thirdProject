package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.PurchaseOrderTest;

import java.util.List;

public interface PurchaseOrderMapper {
    //获取id
    PurchaseOrderTest selectByPrimaryKey(String id);

    //查询所有
    List<PurchaseOrderTest> selectAll();

    //增加
    int insert(PurchaseOrderTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(PurchaseOrderTest record);
}
