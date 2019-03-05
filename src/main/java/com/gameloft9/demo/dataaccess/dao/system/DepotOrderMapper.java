package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;

import java.util.List;

public interface DepotOrderMapper {
    //获取id
    DepotOrderTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotOrderTest> selectAll();

    //增加
    int insert(DepotOrderTest record);

    //删除
    int deleteByPrimaryKey(DepotOrderTest record);

    //修改
    int updateByPrimaryKey(DepotOrderTest record);
}
