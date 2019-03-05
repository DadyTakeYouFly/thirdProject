package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.SupplierTest;

import java.util.List;

public interface SupplierMapper {
    //获取id
    SupplierTest selectByPrimaryKey(String id);

    //查询所有
    List<SupplierTest> selectAll();

    //增加
    int insert(SupplierTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(SupplierTest record);
}
