package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotInventoryMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.service.api.system.DepotInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotInventoryServiceImpl implements DepotInventoryService {

    @Autowired
    DepotInventoryMapper dao;

    //查询所有
    public List<DepotInventoryTest> selectAll() {
        List<DepotInventoryTest> list = dao.selectAll();
        return list;
    }

    //获取id
    public DepotInventoryTest selectByPrimaryKey(String id) {
        DepotInventoryTest depotInventoryTest = dao.selectByPrimaryKey(id);
        return depotInventoryTest;
    }

    //增加
    public void insert(DepotInventoryTest depotInventoryTest) {
        dao.insert(depotInventoryTest);
    }

    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean updateByPrimaryKey(DepotInventoryTest depotInventoryTest) {
        dao.updateByPrimaryKey(depotInventoryTest);
        return true;
    }
}
