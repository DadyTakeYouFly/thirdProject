package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.DepotInventoryTest;
import com.gameloft9.demo.dataaccess.model.system.DepotUseless;

import java.util.Date;
import java.util.List;

public interface DepotUselessService {

    //查询所有
    //List<DepotUseless> selectAll();

    //获取id
    DepotUseless selectByPrimaryKey(String id);

    //增加
    DepotUseless insert(String id, Integer orderType, String goodsId,
                        String goodsNumber, String applyUser, Date applyTime, String state,
                        String orderAuditUser, Date orderAuditTime, String applyDescribe,
                        String auditDescribe);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id, Integer orderType, String goodsId,
                   String goodsNumber, String applyUser, Date applyTime, String state,
                   String orderAuditUser, Date orderAuditTime, String applyDescribe,
                   String auditDescribe);

    /**
     * 获取所有角色
     * @param page 页序
     * @param limit 分页大小
     * */
    List<DepotUseless> getAll(String page, String limit, Integer orderType);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(Integer orderType);
}
