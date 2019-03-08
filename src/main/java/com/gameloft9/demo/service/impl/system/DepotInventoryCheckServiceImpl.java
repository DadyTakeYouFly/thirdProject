package com.gameloft9.demo.service.impl.system;

import com.gameloft9.demo.dataaccess.dao.system.DepotInventoryCheckMapper;
import com.gameloft9.demo.dataaccess.model.system.DepotInventoryCheckTest;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import com.gameloft9.demo.service.api.system.DepotInventoryCheckService;
import com.gameloft9.demo.service.beans.system.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotInventoryCheckServiceImpl implements DepotInventoryCheckService {

    @Autowired
    DepotInventoryCheckMapper dao;

    //查询所有
    //public List<DepotInventoryCheckTest> selectAll() {
    //    List<DepotInventoryCheckTest> list = dao.selectAll();
    //    return list;
    //}

    //获取id
    public DepotInventoryCheckTest selectByPrimaryKey(String id) {
        CheckUtil.notBlank(id,"角色id为空");
        return dao.selectByPrimaryKey(id);
    }

    //增加
    public DepotInventoryCheckTest insert(String id,String sourceUser,String sourceTime,String recordNumber,Integer state) {
        DepotInventoryCheckTest depot = new DepotInventoryCheckTest();
        depot.setId(id);
        depot.setSourceUser(sourceUser);
        depot.setSourceTime(sourceTime);
        depot.setRecordNumber(recordNumber);
        depot.setState(state);
        dao.insert(depot);
        return depot;
    }


    //删除
    public boolean deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
        return true;
    }

    //修改
    public boolean update(String id,String sourceUser,String sourceTime,String recordNumber,Integer state) {
        DepotInventoryCheckTest depot = new DepotInventoryCheckTest();
        depot.setId(id);
        depot.setSourceUser(sourceUser);
        depot.setSourceTime(sourceTime);
        depot.setRecordNumber(recordNumber);
        depot.setState(state);
        dao.update(depot);
        return true;
    }

    /**
     * 获取所有角色
     * */
    public List<DepotInventoryCheckTest> getAll(String page, String limit,String id){
        PageRange pageRange = new PageRange(page,limit);
        return dao.selectAll(pageRange.getStart(),pageRange.getEnd(),id);
    }

    /**
     * 获取所有角色个数
     * */
    public int countGetAll(String id){
        return dao.countGetAll(id);
    }


}
