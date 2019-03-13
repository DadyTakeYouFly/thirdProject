package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.SysOrderCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrderCheckMapper {

    //获取id
    SysOrderCheck selectByPrimaryKey(String id);

    //增加
    int insert(SysOrderCheck record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(SysOrderCheck record);

    //获取所有
    List<SysOrderCheck> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("state") String state,
            @Param("goodsId") String goodsId);

    //获取个数
    int countGetAll(@Param("state") String state,
                    @Param("goodsId") String goodsId);

    //获取下拉框
    List<SysOrderCheck> getFirstClassListState();

    List<SysOrderCheck> getFirstClassListGoods();

    List<SysOrderCheck> getFirstClassListCheck();
}
