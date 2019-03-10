package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.SysInventoryOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SysInventoryOrderService {

    //获取id
    SysInventoryOrder selectByPrimaryKey(String id);

    //添加
    SysInventoryOrder insert(String id, String inventoryId, String orderId, Integer goodsType,
                             String goodsId, String goodsNumber, String applyUser, Date applyTime,
                             String orderAuditUser, Date orderAuditTime);

    //删除
    boolean deleteByPrimaryKey(String id);

    //更新
    boolean update(String id, String inventoryId, String orderId, Integer goodsType,
                   String goodsId, String goodsNumber, String applyUser, Date applyTime,
                   String orderAuditUser, Date orderAuditTime);

    /**
     * 获取所有角色
     * @param page 页序
     * @param limit 分页大小
     * */
    List<SysInventoryOrder> getAll(String page, String limit, String id,String goodsId);

    /**
     * 获取所有角色个数
     * */
    int countGetAll(String id,String goodsId);
}
