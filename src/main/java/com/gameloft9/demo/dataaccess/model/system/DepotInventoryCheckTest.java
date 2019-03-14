package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

@Data
public class DepotInventoryCheckTest {
    private String id;
    private String sourceUser;
    private String sourceTime;
    private String recordNumber;
    private Integer state;

    @Override
    public String toString() {
        return "DepotInventoryCheckTest{" +
                "id='" + id + '\'' +
                ", sourceUser='" + sourceUser + '\'' +
                ", sourceTime='" + sourceTime + '\'' +
                ", recordNumber='" + recordNumber + '\'' +
                ", state=" + state +
                '}';
    }
}
