package com.gameloft9.demo.controllers.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.service.api.system.DepotInventoryService;
import com.gameloft9.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public List<DepotInventoryTest> selectAll(){
        List<DepotInventoryTest> list = service.selectAll();
        return list;
    }

    /*根据id获取该id数据*/
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap selectByPrimaryKey(@PathVariable String id){
        DepotInventoryTest dept = service.selectByPrimaryKey(id);
        return ResultMap.okData(dept);
    }

    /*添加库存*/
    /*二次跳转，页面跳转*/
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(){
        System.out.println("跳转添加商品页面");
        return "insert.do";
    }

    @RequestMapping(value="/insert.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap insert(DepotInventoryTest depotInventoryTest){
        service.insert(depotInventoryTest);
        return ResultMap.ok();
    }

    /*删除库存*/
    @RequestMapping(value = "/delete.do",method = RequestMethod.GET)
    @ResponseBody
    public ResultMap delete(String id){
        boolean flag = service.deleteByPrimaryKey(id);
        if(flag){
            System.out.println("成功删除第" + id + "号商品");
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
        DepotInventoryTest depot = service.selectByPrimaryKey(id);
        request.setAttribute("depot",depot);
        return "update.do";
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultMap update(DepotInventoryTest depotInventoryTest){
        boolean flag = service.updateByPrimaryKey(depotInventoryTest);
        if(flag){
            System.out.println("商品" + depotInventoryTest + "  修改成功");
            return ResultMap.ok();
        }else{
            System.out.println("修改商品" + depotInventoryTest + "失败，请重试");
            return ResultMap.fail();
        }
    }

}
