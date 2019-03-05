package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.MaterialTest;

import java.util.List;

public interface MaterialMapper {
    //获取id
    MaterialTest selectByPrimaryKey(String id);

    //查询所有
    List<MaterialTest> selectAll();

    //增加
    int insert(MaterialTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(MaterialTest record);

}
