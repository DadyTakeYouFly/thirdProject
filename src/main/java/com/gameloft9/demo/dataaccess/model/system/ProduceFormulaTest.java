package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProduceFormulaTest {
    private String id;
    private String productName;
    private Integer goodsType;
    private String createUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public String toString() {
        return "ProduceFormulaTest{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", goodsType=" + goodsType +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ProduceFormulaTest(String id, String productName, Integer goodsType, String createUser, Date createTime) {
        this.id = id;
        this.productName = productName;
        this.goodsType = goodsType;
        this.createUser = createUser;
        this.createTime = createTime;
    }

    public ProduceFormulaTest() {
    }
}
