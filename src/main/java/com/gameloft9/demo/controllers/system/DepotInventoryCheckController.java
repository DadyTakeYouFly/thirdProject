package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;
import com.gameloft9.demo.service.api.system.DepotInventoryCheckService;
import com.gameloft9.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*仓库库存盘点总表Controller*/
@Controller
@RequestMapping("/depot/inventory/check")
public class DepotInventoryCheckController {

    @Autowired
    DepotInventoryCheckService service;

    /*获取所有资料*/
    @RequestMapping(value="/list.do",method = RequestMethod.POST)
    @ResponseBody
    public List<DepotInventoryCheckTest> selectAll(){
        List<DepotInventoryCheckTest> list = service.selectAll();
        return list;
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap selectByPrimaryKey(@PathVariable String id){
        DepotInventoryCheckTest dept = service.selectByPrimaryKey(id);
        return ResultMap.okData(dept);
    }

    /*添加库存*/
    /*二次跳转，页面跳转*/
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(){
        System.out.println("跳转添加商品库存页面");
        return "insert.do";
    }

    @RequestMapping(value="/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap insert(DepotInventoryCheckTest depotInventorycheckTest){
        service.insert(depotInventorycheckTest);
        return ResultMap.ok();
    }

    /*删除库存*/
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap delete(String id){
        boolean flag = service.deleteByPrimaryKey(id);
        if(flag){
            System.out.println("成功删除第" + id + "号库存商品");
            return ResultMap.ok();
        }else{
            System.out.println("删除" + id + "号库存商品失败，请重试");
            return ResultMap.fail();
        }
    }

    /*修改库存*/
    /*先获取要修改商品的id，再进行修改*/
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String updateId(@PathVariable String id, HttpServletRequest request){
        DepotInventoryCheckTest depot = service.selectByPrimaryKey(id);
        request.setAttribute("depot",depot);
        return "update.do";
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap update(DepotInventoryCheckTest depotInventorycheckTest){
        boolean flag = service.updateByPrimaryKey(depotInventorycheckTest);
        if(flag){
            System.out.println("库存商品：" + depotInventorycheckTest + "  修改成功");
            return ResultMap.ok();
        }else{
            System.out.println("修改库存商品" + depotInventorycheckTest + "失败，请重试");
            return ResultMap.fail();
        }
    }
}
