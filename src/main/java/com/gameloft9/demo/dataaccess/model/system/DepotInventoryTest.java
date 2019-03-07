package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

@Data
public class DepotInventoryTest {
    private String id;
    private Integer goodsType;
    private String goodsId;
    private String goodsNumber;

    @Override
    public String toString() {
        return "DepotInventoryTest{" +
                "id='" + id + '\'' +
                ", goodsType=" + goodsType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                '}';
    }
}
