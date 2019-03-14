package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotOrder;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepotOrderOutMapper {

    //获取id
    DepotOrderOut selectByPrimaryKey(String id);

    //增加
    int insert(DepotOrderOut record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotOrderOut record);


    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotOrderOut> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("orderType") Integer orderType,
            @Param("state") String state);


    /**
     * 获取所有角色个数
     * */
    int countGetAll(@Param("orderType") Integer orderType,
                    @Param("state") String state);

    //获取下拉框
    List<DepotOrderOut> getFirstClassListState();
}
