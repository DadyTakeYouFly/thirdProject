package com.gameloft9.demo.dataaccess.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
public class DepotUseless {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private Integer orderType;
    private String goodsId;
    private String goodsNumber;
    private String applyUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date applyTime;
    private String state;
    private String orderAuditUser;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date orderAuditTime;
    private String applyDescribe;
    private String auditDescribe;

    @Override
    public String toString() {
        return "DepotOrderTest{" +
                "id='" + id + '\'' +
                ", orderType=" + orderType +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyTime=" + applyTime +
                ", state='" + state + '\'' +
                ", orderAuditUser='" + orderAuditUser + '\'' +
                ", orderAuditTime=" + orderAuditTime +
                ", applyDescribe='" + applyDescribe + '\'' +
                ", auditDescribe='" + auditDescribe + '\'' +
                '}';
    }

}
