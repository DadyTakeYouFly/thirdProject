package com.gameloft9.demo.service.api.system;
import com.gameloft9.demo.dataaccess.model.system.DepotOrderTest;
import com.gameloft9.demo.dataaccess.model.system.UserTest;

import java.util.Date;
import java.util.List;

public interface DepotOrderService {

//        //获取所有
//        List<DepotOrderTest> selectAll();

        //获取id
        DepotOrderTest selectByPrimaryKey(String id);

        //添加
        DepotOrderTest insert(String id, Integer orderType, String goodsId,
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
        List<DepotOrderTest> getAll(String page, String limit, Integer orderType);

        /**
         * 获取所有角色个数
         * */
        int countGetAll(Integer orderType);


}

