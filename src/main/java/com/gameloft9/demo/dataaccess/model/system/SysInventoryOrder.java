package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

import java.util.Date;

@Data
public class SysInventoryOrder {
    private String id;
    private String inventoryId;
    private String orderId;
    private Integer goodsType;
    private String goodsId;
    private String goodsNumber;
    private String applyUser;
    private Date applyTime;
    private String orderAuditUser;
    private Date orderAuditTime;

    @Override
    public String toString() {
        return "SysInventoryOrder{" +
                "id='" + id + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsType=" + goodsType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyTime=" + applyTime +
                ", orderAuditUser='" + orderAuditUser + '\'' +
                ", orderAuditTime=" + orderAuditTime +
                '}';
    }
}
