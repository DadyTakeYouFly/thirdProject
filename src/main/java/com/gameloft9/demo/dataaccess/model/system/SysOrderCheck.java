package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

@Data
public class SysOrderCheck {
    private String id;
    private String checkId;
    private Integer orderType;
    private String goodsId;
    private String goodsNumber;
    private String auditUser;
    private String state;

    @Override
    public String toString() {
        return "SysOrderCheck{" +
                "id='" + id + '\'' +
                ", checkId='" + checkId + '\'' +
                ", orderType=" + orderType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", auditUser='" + auditUser + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
