package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotOrderMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;
import com.gameloft9.demo.service.api.system.DepotOrderService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotOrderServiceImpl implements DepotOrderService {

    @Autowired
    DepotOrderMapper dao;

    //查询所有
    public List<DepotOrderTest> selectAll() {
        List<DepotOrderTest> list = dao.selectAll();
        return list;
    }

    //获取id
    public DepotOrderTest selectByPrimaryKey(String id) {
        DepotOrderTest depotOrderTest = dao.selectByPrimaryKey(id);
        return depotOrderTest;
    }

    //增加
    public void insert(DepotOrderTest depotOrderTest) {
        dao.insert(depotOrderTest);
    }

    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean updateByPrimaryKey(DepotOrderTest depotOrderTest) {
        dao.updateByPrimaryKey(depotOrderTest);
        return true;
    }

     //分页获取用户列表
     //@param page         页序
     //@param limit        分页大小
     //@param loginName     登录名
     //@param realName     姓名
     //@param status       状态 0-禁用 1-启用
     public String getAll(String page, String limit,String loginName,String status) {
        PageRange pageRange = new PageRange(page, limit);
        return dao.getAll(pageRange.getStart(), pageRange.getEnd(),status);
     }


}
