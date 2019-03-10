package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.SysInventoryOrderMapper;
import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.SysInventoryOrderService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SysInventoryOrderServiceImpl implements SysInventoryOrderService {

    @Autowired
    SysInventoryOrderMapper dao;

    public SysInventoryOrder selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    public SysInventoryOrder insert(String id, String inventoryId, String orderId, Integer goodsType,
                                    String goodsId, String goodsNumber, String applyUser,
                                    Date applyTime, String orderAuditUser, Date orderAuditTime) {
        SysInventoryOrder sys = new SysInventoryOrder();
        sys.setId(id);
        sys.setInventoryId(inventoryId);
        sys.setOrderId(orderId);
        sys.setGoodsType(goodsType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setApplyUser(applyUser);
        sys.setApplyTime(applyTime);
        sys.setOrderAuditUser(orderAuditUser);
        sys.setOrderAuditTime(orderAuditTime);
        dao.insert(sys);
        return sys;
    }

    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    public boolean update(String id, String inventoryId, String orderId, Integer goodsType,
                          String goodsId, String goodsNumber, String applyUser,
                          Date applyTime, String orderAuditUser, Date orderAuditTime) {
        SysInventoryOrder sys = new SysInventoryOrder();
        sys.setId(id);
        sys.setInventoryId(inventoryId);
        sys.setOrderId(orderId);
        sys.setGoodsType(goodsType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setApplyUser(applyUser);
        sys.setApplyTime(applyTime);
        sys.setOrderAuditUser(orderAuditUser);
        sys.setOrderAuditTime(orderAuditTime);
        dao.update(sys);
        return true;
    }

    public List<SysInventoryOrder> getAll(String page, String limit, String id, String goodsId) {
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),id,goodsId);
    }

    public int countGetAll(String id, String goodsId) {
        return dao.countGetAll(id,goodsId);
    }
}
