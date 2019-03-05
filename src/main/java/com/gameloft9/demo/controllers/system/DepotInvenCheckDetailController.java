package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckDetailTest;
import com.gameloft9.demo.service.api.system.DepotInvenCheckDetailService;
import com.gameloft9.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*仓库库存盘点明细记录*/
@Controller
@RequestMapping("/depot/inventory/check/detail")
public class DepotInvenCheckDetailController {

    @Autowired
    DepotInvenCheckDetailService service;

    /*获取所有资料*/
    @RequestMapping(value="/list.do",method = RequestMethod.POST)
    @ResponseBody
    public List<DepotInventoryCheckDetailTest> selectAll(){
        List<DepotInventoryCheckDetailTest> list = service.selectAll();
        return list;
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap selectByPrimaryKey(@PathVariable String id){
        DepotInventoryCheckDetailTest dept = service.selectByPrimaryKey(id);
        return ResultMap.okData(dept);
    }

    /*添加库存*/
    /*二次跳转，页面跳转*/
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(){
        System.out.println("跳转添加商品明细记录页面");
        return "insert.do";
    }

    @RequestMapping(value="/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap insert(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest){
        service.insert(depotInventoryCheckDetailTest);
        return ResultMap.ok();
    }

    /*删除库存*/
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap delete(String id){
        boolean flag = service.deleteByPrimaryKey(id);
        if(flag){
            System.out.println("成功删除第" + id + "条商品明细记录");
            return ResultMap.ok();
        }else{
            System.out.println("删除第" + id + "条库存商品明细记录失败，请重试");
            return ResultMap.fail();
        }
    }

    /*修改库存*/
    /*先获取要修改商品的id，再进行修改*/
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String updateId(@PathVariable String id, HttpServletRequest request){
        DepotInventoryCheckDetailTest depot = service.selectByPrimaryKey(id);
        request.setAttribute("depot",depot);
        return "update.do";
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap update(DepotInventoryCheckDetailTest depotInventoryCheckDetailTest){
        boolean flag = service.updateByPrimaryKey(depotInventoryCheckDetailTest);
        if(flag){
            System.out.println("商品明细记录" + depotInventoryCheckDetailTest + "  修改成功");
            return ResultMap.ok();
        }else{
            System.out.println("商品明细记录" + depotInventoryCheckDetailTest + "修改失败，请重试");
            return ResultMap.fail();
        }
    }
}
