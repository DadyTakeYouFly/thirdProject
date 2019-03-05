package com.gameloft9.demo.dataaccess.model.system;

public class DepotInventoryCheckDetailTest {
    private String id;
    private String checkId;
    private Integer goodsType;
    private String goodsId;
    private String goodsNumber;
    private String auditUser;

    @Override
    public String toString() {
        return "DepotInventoryCheckDetailTest{" +
                "id='" + id + '\'' +
                ", checkId='" + checkId + '\'' +
                ", goodsType=" + goodsType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", auditUser='" + auditUser + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
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

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public DepotInventoryCheckDetailTest(String id, String checkId, Integer goodsType, String goodsId, String goodsNumber, String auditUser) {
        this.id = id;
        this.checkId = checkId;
        this.goodsType = goodsType;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.auditUser = auditUser;
    }

    public DepotInventoryCheckDetailTest() {
    }
}
