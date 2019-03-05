package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProduceFormulaDetailTest {
    private String id;
    private String productFormulaId;
    private String materialId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date materialNumber;

    @Override
    public String toString() {
        return "ProduceFormulaDetailTest{" +
                "id='" + id + '\'' +
                ", productFormulaId='" + productFormulaId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", materialNumber=" + materialNumber +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductFormulaId() {
        return productFormulaId;
    }

    public void setProductFormulaId(String productFormulaId) {
        this.productFormulaId = productFormulaId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Date getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(Date materialNumber) {
        this.materialNumber = materialNumber;
    }

    public ProduceFormulaDetailTest(String id, String productFormulaId, String materialId, Date materialNumber) {
        this.id = id;
        this.productFormulaId = productFormulaId;
        this.materialId = materialId;
        this.materialNumber = materialNumber;
    }

    public ProduceFormulaDetailTest() {
    }
}
