package com.gameloft9.demo.dataaccess.model.system;

public class MaterialTest {
    private String id;
    private String goodsName;
    private Integer goodsType;
    private String goodsDescribe;

    @Override
    public String toString() {
        return "MaterialTest{" +
                "id='" + id + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType=" + goodsType +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public MaterialTest(String id, String goodsName, Integer goodsType, String goodsDescribe) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsDescribe = goodsDescribe;
    }

    public MaterialTest() {
    }
}
