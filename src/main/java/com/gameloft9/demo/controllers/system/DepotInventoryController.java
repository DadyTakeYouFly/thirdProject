package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.beans.response.PageResultBean;
import com.gameloft9.demo.mgrframework.beans.response.ResultBean;
import com.gameloft9.demo.service.api.system.DepotInventoryService;
import com.gameloft9.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/*仓库库存表Controller*/

@Controller
@RequestMapping("/depot/inventory")
public class DepotInventoryController {

    @Autowired
    DepotInventoryService service;

    /*获取所有资料*/
    @RequestMapping(value="/list.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectAll(String page, String limit,Integer goodsType){
        return new PageResultBean<Collection<DepotInventoryTest>>(service.getAll(page,limit,goodsType),service.countGetAll(goodsType));
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult selectByPrimaryKey(String id){
        return new ResultBean<DepotInventoryTest>(service.selectByPrimaryKey(id));
    }

    /*添加库存*/
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public IResult insert(String id,Integer goodsType,String goodsId,String goodsNumber){
        return new ResultBean<DepotInventoryTest>(service.insert(id,goodsType,goodsId,goodsNumber));
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
    public IResult updateId(String id,Integer goodsType,String goodsId,String goodsNumber){
        return new ResultBean<Boolean>(service.update(id,goodsType,goodsId,goodsNumber));

    }
}
