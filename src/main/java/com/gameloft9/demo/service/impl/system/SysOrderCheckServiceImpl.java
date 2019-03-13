package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.SysOrderCheckMapper;
import com.gameloft9.demo.dataaccess.model.system.SysOrderCheck;
import com.gameloft9.demo.service.api.system.SysOrderCheckService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysOrderCheckServiceImpl implements SysOrderCheckService {

    @Autowired
    SysOrderCheckMapper dao;

    public SysOrderCheck selectByPrimaryKey(String id) {
        return  dao.selectByPrimaryKey(id);
    }

    public SysOrderCheck insert(String id,String checkId,Integer orderType, String goodsId, String goodsNumber,
                                String auditUser,String state) {
        SysOrderCheck sys = new SysOrderCheck();
        sys.setId(id);
        sys.setCheckId(checkId);
        sys.setOrderType(orderType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setAuditUser(auditUser);
        sys.setState(state);
        dao.insert(sys);
        return sys;
    }

    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    public boolean update(String id,String checkId, Integer orderType,
                          String goodsId, String goodsNumber, String auditUser,String state) {
        SysOrderCheck sys = new SysOrderCheck();
        sys.setId(id);
        sys.setCheckId(checkId);
        sys.setOrderType(orderType);
        sys.setGoodsId(goodsId);
        sys.setGoodsNumber(goodsNumber);
        sys.setAuditUser(auditUser);
        sys.setState(state);
        dao.update(sys);
        return true;
    }

    public List<SysOrderCheck> getAll(String page, String limit, String checkId, String goodsId) {
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),checkId,goodsId);
    }

    public int countGetAll(String checkId,String goodsId) {
        return dao.countGetAll(checkId,goodsId);
    }

    //获取菜单列表下拉框内容
    public List<SysOrderCheck> getFirstClassListCheck(){
        List<SysOrderCheck> sys = new ArrayList<SysOrderCheck>();
        sys = dao.getFirstClassListCheck();
        return sys;
    }

    public List<SysOrderCheck> getFirstClassListGoods(){
        List<SysOrderCheck> sys = new ArrayList<SysOrderCheck>();
        sys = dao.getFirstClassListGoods();
        return sys;
    }

}
