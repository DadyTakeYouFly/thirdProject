package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    //获取id
    Supplier selectByPrimaryKey(String id);

    //查询所有
    List<Supplier> selectAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("supplierName") String supplierName);

    //增加
    int insert(Supplier record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int update(Supplier record);

    //获取所有的个数
    int countGetAll(
            @Param("supplierName") String supplierName);

}
