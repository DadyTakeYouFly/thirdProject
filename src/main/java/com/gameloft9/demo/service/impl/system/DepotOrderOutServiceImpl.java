package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotOrderMapper;
import com.gameloft9.demo.dataaccess.dao.system.DepotOrderOutMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotOrder;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderOut;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.DepotOrderOutService;
import com.gameloft9.demo.service.api.system.DepotOrderService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepotOrderOutServiceImpl implements DepotOrderOutService {

    @Autowired
    DepotOrderOutMapper dao;

    //获取id
    public DepotOrderOut selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    //增加
    public DepotOrderOut insert(String id, Integer orderType, String goodsId, String goodsNumber,
                             String applyUser, Date applyTime, String state,
                             String orderAuditUser, Date orderAuditTime, String applyDescribe,
                             String auditDescribe) {
        DepotOrderOut depot = new DepotOrderOut();
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
        DepotOrderOut depot = new DepotOrderOut();
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
    public List<DepotOrderOut> getAll(String page, String limit, Integer orderType,String state){
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),orderType,state);
    }

    /**
     * 获取所有角色个数
     * */
    public int countGetAll(Integer orderType,String state){
        return dao.countGetAll(orderType,state);
    }


    //获取菜单列表下拉框内容
    public List<DepotOrderOut> getFirstClassListState(){
        List<DepotOrderOut> sys = new ArrayList<DepotOrderOut>();
        sys = dao.getFirstClassListState();
        return sys;
    }
}
