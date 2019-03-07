package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepotInventoryMapper {
    //获取id
    DepotInventoryTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotInventoryTest> selectAll();

    //增加
    int insert(DepotInventoryTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotInventoryTest record);

    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotInventoryTest> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("goodsType") Integer goodsType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(@Param("goodsType") Integer goodsType);
}
