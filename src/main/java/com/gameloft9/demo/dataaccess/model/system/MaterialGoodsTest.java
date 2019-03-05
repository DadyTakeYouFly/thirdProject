package com.gameloft9.demo.dataaccess.model.system;

public class MaterialGoodsTest {
    private String id;
    private String supplierId;
    private String materialId;
    private String goodsPrice;

    @Override
    public String toString() {
        return "MaterialGoodsTest{" +
                "id='" + id + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public MaterialGoodsTest(String id, String supplierId, String materialId, String goodsPrice) {
        this.id = id;
        this.supplierId = supplierId;
        this.materialId = materialId;
        this.goodsPrice = goodsPrice;
    }

    public MaterialGoodsTest() {
    }
}
