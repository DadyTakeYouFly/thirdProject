package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotInventoryCheckMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;
import com.gameloft9.demo.service.api.system.DepotInventoryCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotInventoryCheckServiceImpl implements DepotInventoryCheckService {

    @Autowired
    DepotInventoryCheckMapper dao;

    //查询所有
    public List<DepotInventoryCheckTest> selectAll() {
        List<DepotInventoryCheckTest> list = dao.selectAll();
        return list;
    }

    //获取id
    public DepotInventoryCheckTest selectByPrimaryKey(String id) {
        DepotInventoryCheckTest depotInventoryCheckTest = dao.selectByPrimaryKey(id);
        return depotInventoryCheckTest;
    }

    //增加
    public void insert(DepotInventoryCheckTest depotInventoryCheckTest) {
        dao.insert(depotInventoryCheckTest);
    }


    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean updateByPrimaryKey(DepotInventoryCheckTest depotInventoryCheckTest) {
        dao.updateByPrimaryKey(depotInventoryCheckTest);
        return true;
    }
}
