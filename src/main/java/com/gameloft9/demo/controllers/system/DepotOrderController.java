package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotOrder;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.DepotOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;


/*仓库订单Controller*/

@Controller
@RequestMapping("/depot/order")
public class DepotOrderController {

    @Autowired
    DepotOrderService service;

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
    public IResult selectAll(String page, String limit,Integer orderType,String state){
        return new PageResultBean<Collection<DepotOrder>>(service.getAll(page,limit,orderType,state),service.countGetAll(orderType,state));
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectByPrimaryKey(String id){
       return new ResultBean<DepotOrder>(service.selectByPrimaryKey(id));
    }

    /*添加库存*/
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id, Integer orderType, String goodsId,
                          String goodsNumber, String applyUser, Date applyTime,String state,
                          String orderAuditUser,Date orderAuditTime,String applyDescribe,
                          String auditDescribe){
        return new ResultBean<DepotOrder>(service.insert(id,orderType,goodsId,goodsNumber,applyUser,
                applyTime,state,orderAuditUser,orderAuditTime,applyDescribe,auditDescribe));
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
    public IResult updateId(String id, Integer orderType, String goodsId,
                            String goodsNumber, String applyUser, Date applyTime,String state,
                            String orderAuditUser,Date orderAuditTime,String applyDescribe,
                            String auditDescribe){
        return new ResultBean<Boolean>(service.update(id,orderType,goodsId,goodsNumber,applyUser,
                applyTime,state,orderAuditUser,orderAuditTime,applyDescribe,auditDescribe));
    }

    /**
     * 获取所有菜单列表下拉框
     * */
    @RequestMapping(value = "/firstClassDepotState.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult getFirstMenuListState(){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Collection<DepotOrder>>(service.getFirstClassListState());
    }

}
