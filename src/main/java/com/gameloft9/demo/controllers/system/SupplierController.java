package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.Supplier;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService service;

    //获取列表
    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectAll(String page,String limit,String supplierName){
        return new PageResultBean<Collection<Supplier>>(service.selectAll(page,limit,supplierName),
                service.countGetAll(supplierName));
    }

    //根据id获取
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult getByPrimaryKey(String id){
        return new ResultBean<Supplier>(service.selectByPrimaryKey(id));
    }

    //增加
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id,String supplierName,String supplierDescribe,String phone){
        return new ResultBean<Supplier>(service.insert(id,supplierName,supplierDescribe,phone));
    }

    //删除
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public IResult deleteByPrimaryKey(String id){
        return new ResultBean<Boolean>(service.deleteByPrimaryKey(id));
    }

    //修改
    //获取所有个数
}
