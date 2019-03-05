package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;

import java.util.List;

public interface DepotInventoryCheckMapper {

    //获取id
    DepotInventoryCheckTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotInventoryCheckTest> selectAll();

    //增加
    int insert(DepotInventoryCheckTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(DepotInventoryCheckTest record);
}
