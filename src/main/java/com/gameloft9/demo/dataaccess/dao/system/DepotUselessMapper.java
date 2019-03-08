package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.dataaccess.model.system.DepotUseless;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepotUselessMapper {
    //获取id
    DepotUseless selectByPrimaryKey(String id);

    //查询所有
    List<DepotUseless> selectAll();

    //增加
    int insert(DepotUseless record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(DepotUseless record);

    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<DepotUseless> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("orderType") Integer orderType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("orderType") Integer orderType);
}
