package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PurchaseOrderTest {
    private String id;
    private String iD_Number;
    private String goodsId;
    private String goodsNumber;
    private String applyUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;
    private String state;
    private String orderAuditUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderAuditTime;
    private String payAuditUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datePayAuditTime;
    private String applyDescribe;
    private String auditDescribe;

    @Override
    public String toString() {
        return "PurchaseOrderTest{" +
                "id='" + id + '\'' +
                ", iD_Number='" + iD_Number + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyTime=" + applyTime +
                ", state='" + state + '\'' +
                ", orderAuditUser='" + orderAuditUser + '\'' +
                ", orderAuditTime=" + orderAuditTime +
                ", payAuditUser='" + payAuditUser + '\'' +
                ", datePayAuditTime=" + datePayAuditTime +
                ", applyDescribe='" + applyDescribe + '\'' +
                ", auditDescribe='" + auditDescribe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getiD_Number() {
        return iD_Number;
    }

    public void setiD_Number(String iD_Number) {
        this.iD_Number = iD_Number;
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

    public String getPayAuditUser() {
        return payAuditUser;
    }

    public void setPayAuditUser(String payAuditUser) {
        this.payAuditUser = payAuditUser;
    }

    public Date getDatePayAuditTime() {
        return datePayAuditTime;
    }

    public void setDatePayAuditTime(Date datePayAuditTime) {
        this.datePayAuditTime = datePayAuditTime;
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

    public PurchaseOrderTest(String id, String iD_Number, String goodsId, String goodsNumber, String applyUser, Date applyTime, String state, String orderAuditUser, Date orderAuditTime, String payAuditUser, Date datePayAuditTime, String applyDescribe, String auditDescribe) {
        this.id = id;
        this.iD_Number = iD_Number;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.applyUser = applyUser;
        this.applyTime = applyTime;
        this.state = state;
        this.orderAuditUser = orderAuditUser;
        this.orderAuditTime = orderAuditTime;
        this.payAuditUser = payAuditUser;
        this.datePayAuditTime = datePayAuditTime;
        this.applyDescribe = applyDescribe;
        this.auditDescribe = auditDescribe;
    }

    public PurchaseOrderTest() {
    }
}
