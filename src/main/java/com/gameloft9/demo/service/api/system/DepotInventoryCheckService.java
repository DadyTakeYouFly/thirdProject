package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;

import java.util.List;

public interface DepotInventoryCheckService {

    //获取所有
    //List<DepotInventoryCheckTest> selectAll();

    //获取id
    DepotInventoryCheckTest selectByPrimaryKey(String id);

    //增加
    DepotInventoryCheckTest insert(String id,String sourceUser,String sourceTime,String recordNumber,
                                   Integer state);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id,String sourceUser,String sourceTime,String recordNumber,
                               Integer state);

    /**
     * 获取所有角色
     * @param page 页序
     * @param limit 分页大小
     * */
    List<DepotInventoryCheckTest> getAll(String page, String limit, String id);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String id);
}
