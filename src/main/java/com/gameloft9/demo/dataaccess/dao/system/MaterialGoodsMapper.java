package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.MaterialGoodsTest;

import java.util.List;

public interface MaterialGoodsMapper {
    //获取id
    MaterialGoodsTest selectByPrimaryKey(String id);

    //查询所有
    List<MaterialGoodsTest> selectAll();

    //增加
    int insert(MaterialGoodsTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(MaterialGoodsTest record);
}
