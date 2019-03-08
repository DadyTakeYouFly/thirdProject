package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.DepotInventoryCheckService;
import com.gameloft9.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/*仓库库存盘点总表Controller*/
@Controller
@RequestMapping("/depot/check")
public class DepotInventoryCheckController {

    @Autowired
    DepotInventoryCheckService service;

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
    public IResult selectAll(String page, String limit,String id){
        return new PageResultBean<Collection<DepotInventoryCheckTest>>(service.getAll(page,limit,id),service.countGetAll(id));
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectByPrimaryKey(String id){
        return new ResultBean<DepotInventoryCheckTest>(service.selectByPrimaryKey(id));
    }

    /*添加库存*/
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id,String sourceUser,String sourceTime,String recordNumber,Integer state){
        return new ResultBean<DepotInventoryCheckTest>(service.insert(id,sourceUser,sourceTime, recordNumber,state));
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
    public IResult updateId(String id,String sourceUser,String sourceTime,String recordNumber,Integer state){
        return new ResultBean<Boolean>(service.update(id,sourceUser,sourceTime,recordNumber,state));
    }

}
