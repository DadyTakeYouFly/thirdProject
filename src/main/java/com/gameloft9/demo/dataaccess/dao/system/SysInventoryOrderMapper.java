package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysInventoryOrderMapper {


    //获取id
    SysInventoryOrder selectByPrimaryKey(String id);

    //查询所有
    //List<DepotOrderTest> selectAll();

    //增加
    int insert(SysInventoryOrder record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(SysInventoryOrder record);


    /**
     * 获取所有角色
     * @param start 开始
     * @param end 结束
     * */
    List<SysInventoryOrder> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("id") String id,
            @Param("goodsId") String goodsId);
    //@Param("state") String state


    /**
     * 获取所有角色个数
     * */
    int countGetAll( @Param("id") String id,
                     @Param("goodsId") String goodsId);
    //@Param("state") String state

}
