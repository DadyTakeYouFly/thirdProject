package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepotInventoryCheckMapper {

    //获取id
    DepotInventoryCheckTest selectByPrimaryKey(String id);

    //查询所有
    //List<DepotInventoryCheckTest> selectAll();

    //增加
    int insert(DepotInventoryCheckTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotInventoryCheckTest record);

    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotInventoryCheckTest> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("id") String id);


    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("id") String id);
}
