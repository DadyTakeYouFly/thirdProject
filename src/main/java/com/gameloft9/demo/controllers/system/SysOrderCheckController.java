package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.SysOrderCheck;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.SysOrderCheckService;
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
@RequestMapping("/sysOC")
public class SysOrderCheckController {

    @Autowired
    SysOrderCheckService service;

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
    public IResult selectAll(String page, String limit,String checkId, String goodsId){
        return new PageResultBean<Collection<SysOrderCheck>>(service.getAll(page,limit,checkId,goodsId),service.countGetAll(checkId,goodsId));
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectByPrimaryKey(String id){
        return new ResultBean<SysOrderCheck>(service.selectByPrimaryKey(id));
    }

    /*添加库存*/
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id,String checkId,Integer orderType, String goodsId, String goodsNumber,
                          String auditUser,String state){
        return new ResultBean<SysOrderCheck>(service.insert(id,checkId,orderType,goodsId,goodsNumber,
                auditUser,state));
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
    public IResult updateId(String id, String checkId,Integer orderType,
                            String goodsId, String goodsNumber, String auditUser,String state){
        return new ResultBean<Boolean>(service.update(id,checkId,orderType, goodsId,goodsNumber,
                auditUser,state));
    }

    /**
     * 获取所有菜单列表下拉框
     * */
    @RequestMapping(value = "/firstClassSysCheck.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult getFirstMenuListCheck(){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Collection<SysOrderCheck>>(service.getFirstClassListCheck());
    }

    @RequestMapping(value = "/firstClassSysGoods.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult getFirstMenuListGoods(){
        //返回json至前端的均返回ResultBean或者PageResultBean
        return new ResultBean<Collection<SysOrderCheck>>(service.getFirstClassListGoods());
    }
}
