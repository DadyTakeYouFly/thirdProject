package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.SupplierMapper;
import com.gameloft9.demo.dataaccess.model.system.Supplier;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.SupplierService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierMapper dao;

    //查询所有
    public List<Supplier> selectAll(String page,String limit, String supplierName) {
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),supplierName);
    }

    //根据id查找
    public Supplier selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    //增加
    public Supplier insert(String id,String supplierName,String supplierDescribe,String phone) {
        Supplier sup = new Supplier();
        sup.setId(id);
        sup.setSupplierName(supplierName);
        sup.setSupplierDescribe(supplierDescribe);
        sup.setPhone(phone);
        dao.insert(sup);
        return sup;
    }

    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean update(String id,String supplierName,String supplierDescribe,String phone) {
        Supplier sup = new Supplier();
        sup.setId(id);
        sup.setSupplierName(supplierName);
        sup.setSupplierDescribe(supplierDescribe);
        sup.setPhone(phone);
        dao.update(sup);
        return true;
    }

    //获取所有个数
    public int countGetAll(String supplierName) {
        return dao.countGetAll(supplierName);
    }
}
