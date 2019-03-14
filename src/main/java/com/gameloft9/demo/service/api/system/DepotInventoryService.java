package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;

import java.util.List;

public interface DepotInventoryService {

    //查询所有
    //List<DepotInventoryTest> selectAll();

    //获取id
    DepotInventoryTest selectByPrimaryKey(String id);

    //增加
    DepotInventoryTest insert(String id, Integer goodsType, String goodsId, String goodsNumber);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id, Integer goodsType, String goodsId, String goodsNumber);

    /**
     * 获取所有角色
     * @param page 页序
     * @param limit 分页大小
     * */
    List<DepotInventoryTest> getAll(String page, String limit, Integer goodsType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(Integer goodsType);
}
