package com.gameloft9.demo.service.api.system;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;
import com.gameloft9.demo.dataaccess.model.system.UserTest;

import java.util.List;

public interface DepotOrderService {

        //获取所有
        List<DepotOrderTest> selectAll();

        //获取id
        DepotOrderTest selectByPrimaryKey(String id);

        //添加
        void insert(DepotOrderTest depotOrderTest);

        //删除
        boolean deleteByPrimaryKey(String id);

        //更新
        boolean updateByPrimaryKey(DepotOrderTest depotOrderTest);


        //分页获取用户列表
          //@param page         页序
          //@param limit        分页大小
          //@param loginName     登录名
          //@param realName     姓名
          //@param status       状态 0-禁用 1-启用
        String getAll(String page, String limit,String status);


}

