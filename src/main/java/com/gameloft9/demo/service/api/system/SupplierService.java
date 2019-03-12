package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierService {

    //查询所有
    List<Supplier> selectAll(String page, String limit,String supplierName);

    //获取id
    Supplier selectByPrimaryKey(String id);

    //增加
    Supplier insert(String id,String supplierName,String supplierDescribe,String phone);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id,String supplierName,String supplierDescribe,String phone);

    //查询所有个数
    int countGetAll(String supplierName);
}
