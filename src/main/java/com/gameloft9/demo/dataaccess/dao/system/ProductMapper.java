package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProductTest;

import java.util.List;

public interface ProductMapper {
    //获取id
    ProductTest selectByPrimaryKey(String id);

    //查询所有
    List<ProductTest> selectAll();

    //增加
    int insert(ProductTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(ProductTest record);
}
