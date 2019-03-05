package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;

import java.util.List;

public interface DepotInventoryService {

    //查询所有
    List<DepotInventoryTest> selectAll();

    //获取id
    DepotInventoryTest selectByPrimaryKey(String id);

    //增加
    void insert(DepotInventoryTest depotInventoryTest);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean updateByPrimaryKey(DepotInventoryTest depotInventoryTest);
}
