package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;

import java.util.List;

public interface DepotInventoryMapper {
    //获取id
    DepotInventoryTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotInventoryTest> selectAll();

    //增加
    int insert(DepotInventoryTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(DepotInventoryTest record);

}
