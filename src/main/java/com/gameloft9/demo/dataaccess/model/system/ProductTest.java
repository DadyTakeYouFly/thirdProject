package com.gameloft9.demo.dataaccess.model.system;

public class ProductTest {
    private String id;
    private String productName;
    private Integer productType;
    private String productDescribe;

    @Override
    public String toString() {
        return "ProductTest{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productType=" + productType +
                ", productDescribe='" + productDescribe + '\'' +
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

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public ProductTest(String id, String productName, Integer productType, String productDescribe) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.productDescribe = productDescribe;
    }

    public ProductTest() {
    }
}
