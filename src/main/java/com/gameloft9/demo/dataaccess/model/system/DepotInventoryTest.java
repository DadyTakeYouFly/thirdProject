package com.gameloft9.demo.dataaccess.model.system;

public class DepotInventoryTest {
    private String id;
    private Integer goodsType;
    private String goodsId;

    @Override
    public String toString() {
        return "DepotInventoryTest{" +
                "id='" + id + '\'' +
                ", goodsType=" + goodsType +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public DepotInventoryTest(String id, Integer goodsType, String goodsId) {
        this.id = id;
        this.goodsType = goodsType;
        this.goodsId = goodsId;
    }

    public DepotInventoryTest() {
    }
}
