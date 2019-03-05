package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;

import java.util.List;

public interface DepotInventoryCheckService {

    //获取所有
    List<DepotInventoryCheckTest> selectAll();

    //获取id
    DepotInventoryCheckTest selectByPrimaryKey(String id);

    //增加
    void insert(DepotInventoryCheckTest depotInventoryCheckTest);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean updateByPrimaryKey(DepotInventoryCheckTest depotInventoryCheckTest);
}
