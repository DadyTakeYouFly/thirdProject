package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotOrderMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.DepotOrderService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepotOrderServiceImpl implements DepotOrderService {

    @Autowired
    DepotOrderMapper dao;

    //查询所有
//    public List<DepotOrderTest> selectAll() {
//        List<DepotOrderTest> list = dao.selectAll();
//        return list;
//    }

    //获取id
    public DepotOrderTest selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    //增加
    public DepotOrderTest insert(String id, Integer orderType, String goodsId, String goodsNumber,
                                 String applyUser, Date applyTime, String state,
                                 String orderAuditUser, Date orderAuditTime, String applyDescribe,
                                 String auditDescribe) {
        DepotOrderTest depot = new DepotOrderTest();
        depot.setId(id);
        depot.setOrderType(orderType);
        depot.setGoodsId(goodsId);
        depot.setGoodsNumber(goodsNumber);
        depot.setApplyUser(applyUser);
        depot.setApplyTime(applyTime);
        depot.setState(state);
        depot.setOrderAuditUser(orderAuditUser);
        depot.setOrderAuditTime(orderAuditTime);
        depot.setApplyDescribe(applyDescribe);
        depot.setAuditDescribe(auditDescribe);
        dao.insert(depot);
        return depot;
    }

    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean update(String id, Integer orderType, String goodsId, String goodsNumber,
                          String applyUser, Date applyTime, String state, String orderAuditUser,
                          Date orderAuditTime, String applyDescribe, String auditDescribe) {
        DepotOrderTest depot = new DepotOrderTest();
        depot.setId(id);
        depot.setOrderType(orderType);
        depot.setGoodsId(goodsId);
        depot.setGoodsNumber(goodsNumber);
        depot.setApplyUser(applyUser);
        depot.setApplyTime(applyTime);
        depot.setState(state);
        depot.setOrderAuditUser(orderAuditUser);
        depot.setOrderAuditTime(orderAuditTime);
        depot.setApplyDescribe(applyDescribe);
        depot.setAuditDescribe(auditDescribe);
        dao.update(depot);
        return true;
    }

    /**
     * 获取所有角色
     * */
    public List<DepotOrderTest> getAll(String page, String limit, Integer orderType){
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),orderType);
    }

    /**
     * 获取所有角色个数
     * */
    public int countGetAll(Integer orderType){
        return dao.countGetAll(orderType);
    }


}
