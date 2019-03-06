package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
public class DepotOrderTest {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private Integer orderType;
    private String goodsId;
    private String goodsNumber;
    private String applyUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date applyTime;
    private String state;
    private String orderAuditUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date orderAuditTime;
    private String applyDescribe;
    private String auditDescribe;

    @Override
    public String toString() {
        return "DepotOrderTest{" +
                "id='" + id + '\'' +
                ", orderType=" + orderType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyTime=" + applyTime +
                ", state='" + state + '\'' +
                ", orderAuditUser='" + orderAuditUser + '\'' +
                ", orderAuditTime=" + orderAuditTime +
                ", applyDescribe='" + applyDescribe + '\'' +
                ", auditDescribe='" + auditDescribe + '\'' +
                '}';
    }
/*
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderAuditUser() {
        return orderAuditUser;
    }

    public void setOrderAuditUser(String orderAuditUser) {
        this.orderAuditUser = orderAuditUser;
    }

    public Date getOrderAuditTime() {
        return orderAuditTime;
    }

    public void setOrderAuditTime(Date orderAuditTime) {
        this.orderAuditTime = orderAuditTime;
    }

    public String getApplyDescribe() {
        return applyDescribe;
    }

    public void setApplyDescribe(String applyDescribe) {
        this.applyDescribe = applyDescribe;
    }

    public String getAuditDescribe() {
        return auditDescribe;
    }

    public void setAuditDescribe(String auditDescribe) {
        this.auditDescribe = auditDescribe;
    }

    public DepotOrderTest(String id, Integer orderType, String goodsId, String goodsNumber, String applyUser, Date applyTime, String state, String orderAuditUser, Date orderAuditTime, String applyDescribe, String auditDescribe) {
        this.id = id;
        this.orderType = orderType;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.applyUser = applyUser;
        this.applyTime = applyTime;
        this.state = state;
        this.orderAuditUser = orderAuditUser;
        this.orderAuditTime = orderAuditTime;
        this.applyDescribe = applyDescribe;
        this.auditDescribe = auditDescribe;
    }

    public DepotOrderTest() {
    }*/
}
