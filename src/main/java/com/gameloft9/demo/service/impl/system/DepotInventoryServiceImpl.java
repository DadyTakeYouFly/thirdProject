package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotInventoryMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.DepotInventoryService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotInventoryServiceImpl implements DepotInventoryService {

    @Autowired
    DepotInventoryMapper dao;

    //查询所有
    //public List<DepotInventoryTest> selectAll() {
    //    List<DepotInventoryTest> list = dao.selectAll();
    //    return list;
    //}

    //获取id
    public DepotInventoryTest selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    //增加
    public DepotInventoryTest insert(String id,Integer goodsType,String goodsId,String goodsNumber) {
        DepotInventoryTest depot = new DepotInventoryTest();
        depot.setId(id);
        depot.setGoodsType(goodsType);
        depot.setGoodsId(goodsId);
        depot.setGoodsNumber(goodsNumber);
        dao.insert(depot);
        return depot;
    }

    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean update(String id,Integer goodsType,String goodsId,String goodsNumber) {
        DepotInventoryTest depot = new DepotInventoryTest();
        depot.setId(id);
        depot.setGoodsType(goodsType);
        depot.setGoodsId(goodsId);
        depot.setGoodsNumber(goodsNumber);
        dao.update(depot);
        return true;
    }

    /**
     * 获取所有角色
     * */
    public List<DepotInventoryTest> getAll(String page, String limit, Integer goodsType){
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),goodsType);
    }

    /**
     * 获取所有角色个数
     * */
    public int countGetAll(Integer goodsType){
        return dao.countGetAll(goodsType);
    }

}
