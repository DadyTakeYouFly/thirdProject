package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DepotOrderMapper {

    //获取id
    DepotOrderTest selectByPrimaryKey(String id);

    //查询所有
    List<DepotOrderTest> selectAll();

    //增加
    int insert(DepotOrderTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotOrderTest record);


    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotOrderTest> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("orderType") String orderType,
            @Param("state") String state);


    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("orderType") String orderType,
                     @Param("state") String state);

}
