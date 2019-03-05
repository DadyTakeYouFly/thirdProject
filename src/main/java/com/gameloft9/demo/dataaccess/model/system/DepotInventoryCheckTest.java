package com.gameloft9.demo.dataaccess.model.system;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getSourceTime() {
        return sourceTime;
    }

    public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public DepotInventoryCheckTest(String id, String sourceUser, String sourceTime, String recordNumber, Integer state) {
        this.id = id;
        this.sourceUser = sourceUser;
        this.sourceTime = sourceTime;
        this.recordNumber = recordNumber;
        this.state = state;
    }

    public DepotInventoryCheckTest() {
    }
}
