package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotInvenCheckDetailMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckDetailTest;
import com.gameloft9.demo.service.api.system.DepotInvenCheckDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotInvenCheckDetailServiceImpl implements DepotInvenCheckDetailService {

    @Autowired
    DepotInvenCheckDetailMapper dao;

    //获取所有角色
    public List<DepotInventoryCheckDetailTest> selectAll() {
        List<DepotInventoryCheckDetailTest> list = dao.selectAll();
        return list;
    }

    //获取id
    public DepotInventoryCheckDetailTest selectByPrimaryKey(String id) {
        DepotInventoryCheckDetailTest depotInventoryCheckDetailTest = dao.selectByPrimaryKey(id);
        return depotInventoryCheckDetailTest;
    }

    //增加
    public void insert(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest) {
        dao.insert(depotInventoryCheckDetailTest);
    }


    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean updateByPrimaryKey(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest) {
        dao.updateByPrimaryKey(depotInventoryCheckDetailTest);
        return true;
    }
}
