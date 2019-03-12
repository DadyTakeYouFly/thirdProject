package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.SysInventoryOrderMapper;
import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import com.gameloft9.demo.service.api.system.SysInventoryOrderService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysInventoryOrderServiceImpl implements SysInventoryOrderService {

    @Autowired
    SysInventoryOrderMapper dao;

    public List<SysInventoryOrder> selectAll(String page, String limit, String goodsId) {
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),goodsId);
    }

    public SysInventoryOrder selectByPrimaryKey(String id) {
        return dao.selectByPrimaryKey(id);
    }

    public SysInventoryOrder insert(String id, Integer goodsType, String goodsId,
                                    String goodsNumber, String goodsDescribe) {
        SysInventoryOrder sys = new SysInventoryOrder();
        sys.setId(id);
        sys.setGoodsType(goodsType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setGoodsDescribe(goodsDescribe);
        dao.insert(sys);
        return sys;
    }

    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    public boolean update(String id, Integer goodsType, String goodsId, String goodsNumber,
                          String goodsDescribe) {
        SysInventoryOrder sys = new SysInventoryOrder();
        sys.setId(id);
        sys.setGoodsType(goodsType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setGoodsDescribe(goodsDescribe);
        return true;
    }

    public int countGetAll(String goodsId) {
        return dao.countGetAll(goodsId);
    }

    public List<SysInventoryOrder> getFirstClassListGoods() {
        List<SysInventoryOrder> sys = new ArrayList<SysInventoryOrder>();
        sys = dao.getFirstClassListGoods();
        return sys;
    }
}
