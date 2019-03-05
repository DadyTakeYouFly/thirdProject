package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckDetailTest;

import java.util.List;

public interface DepotInvenCheckDetailMapper {

    //获取id
    DepotInventoryCheckDetailTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotInventoryCheckDetailTest> selectAll();

    //增加
    int insert(DepotInventoryCheckDetailTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(DepotInventoryCheckDetailTest record);

}
