package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DepotOrderMapper {

    //获取id
    DepotOrder selectByPrimaryKey(String id);

    //增加
    int insert(DepotOrder record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotOrder record);


    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotOrder> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("orderType") Integer orderType,
            @Param("state") String state);


    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("orderType") Integer orderType,
                     @Param("state") String state);

    //获取下拉框
    List<DepotOrder> getFirstClassListState();
}
