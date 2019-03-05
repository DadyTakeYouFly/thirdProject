package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckDetailTest;

import java.util.List;

public interface DepotInvenCheckDetailService {

    //获取所有
    List<DepotInventoryCheckDetailTest> selectAll();

    //获取id
    DepotInventoryCheckDetailTest selectByPrimaryKey(String id);

    //添加
    void insert(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest);

    //删除
    boolean deleteByPrimaryKey(String id);

    //更新
    boolean updateByPrimaryKey(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest);
}
