package com.gameloft9.demo.service.api.system;
import com.gameloft9.demo.dataaccess.model.system.DepotOrder;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderOut;

import java.util.Date;
import java.util.List;

public interface DepotOrderOutService {

        //获取id
        DepotOrderOut selectByPrimaryKey(String id);

        //添加
        DepotOrderOut insert(String id, Integer orderType, String goodsId,
                          String goodsNumber, String applyUser, Date applyTime, String state,
                          String orderAuditUser, Date orderAuditTime, String applyDescribe,
                          String auditDescribe);

        //删除
        boolean deleteByPrimaryKey(String id);

        //更新
        boolean update(String id, Integer orderType, String goodsId,
                       String goodsNumber, String applyUser, Date applyTime, String state,
                       String orderAuditUser, Date orderAuditTime, String applyDescribe,
                       String auditDescribe);

        /**
         * 获取所有角色
         * @param page 页序
         * @param limit 分页大小
         * */
        List<DepotOrderOut> getAll(String page, String limit, Integer orderType, String state);

        /**
         * 获取所有角色个数
         * */
        int countGetAll(Integer orderType, String state);

        //获取菜单列表下拉框
        List<DepotOrderOut> getFirstClassListState();


}

