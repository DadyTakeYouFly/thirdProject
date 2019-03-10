package com.gameloft9.demo.controllers.system;


import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.SysInventoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/iolist")
public class SysInventoryOrderController {

    @Autowired
    SysInventoryOrderService service;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        // CustomDateEditor为自定义日期编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /*获取所有资料*/
    @RequestMapping(value="/list.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectAll(String page, String limit, String id,String goodsId){
        return new PageResultBean<Collection<SysInventoryOrder>>(service.getAll(page,limit,id,goodsId),service.countGetAll(id,goodsId));
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectByPrimaryKey(String id){
        return new ResultBean<SysInventoryOrder>(service.selectByPrimaryKey(id));
    }

    /*添加库存*/
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id, String inventoryId, String orderId, Integer goodsType,
                          String goodsId, String goodsNumber, String applyUser, Date applyTime,
                          String orderAuditUser, Date orderAuditTime){
        return new ResultBean<SysInventoryOrder>(service.insert(id,inventoryId,orderId,goodsType,
                goodsId,goodsNumber,applyUser,applyTime,orderAuditUser,orderAuditTime));
    }

    /*删除库存*/
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public IResult deleteByPrimaryKey(String id){
        return new ResultBean<Boolean>(service.deleteByPrimaryKey(id));
    }

    /*修改库存*/
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult updateId(String id, String inventoryId, String orderId, Integer goodsType,
                            String goodsId, String goodsNumber, String applyUser, Date applyTime,
                            String orderAuditUser, Date orderAuditTime){
        return new ResultBean<Boolean>(service.update(id,inventoryId,orderId,goodsType,
                goodsId,goodsNumber,applyUser,applyTime,orderAuditUser,orderAuditTime));
    }
}
