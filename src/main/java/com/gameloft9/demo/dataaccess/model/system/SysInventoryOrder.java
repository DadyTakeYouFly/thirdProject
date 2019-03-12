package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

import java.util.Date;

@Data
public class SysInventoryOrder {
    private String id;
    private Integer goodsType;
    private String goodsId;
    private String goodsNumber;
    private String goodsDescribe;

    @Override
    public String toString() {
        return "SysInventoryOrder{" +
                "id='" + id + '\'' +
                ", goodsType=" + goodsType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                '}';
    }
}