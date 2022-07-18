package com.bglobal.linkage.table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TableActivityDTO {
    private Integer id;
    private Integer state;
    private String name;
    private String description;
    private Integer created;
    private Integer modified;
    private String uid;
    private Integer subtotal;
    private Integer tax;
    private Integer total;
    private String tableActivityCode;
    private String tableCode;
    private Integer discountValue;
    private Integer discountPercent;
    private Integer discountType;
    private Integer shopId;
    private Integer sortOrder;
    private String tableActivityUid;
    private Integer tableActivityId;
    private Integer tableActivityState;
    private Integer tableActivityCustomerNumber;
    private TableActivityDetails tableActivityDetails;
    private Integer tableActivityTimerStart;
    private Integer tableActivityTimerDuration;
    private Integer tableActivityFromId;
    private Integer towardTableActivityCode;
    private Integer tableActivityCreated;
    private Integer tableActivityModified;
    private Integer timerState;
    private Integer timerType;
    private Integer timerSetupTime;
    private Integer timerSinceTime;
    private Integer timerTakeOverTime;
    private Integer timerCreated;
    private Integer timerModified;
    private List<Order> orderList;
    private List<OrderDetail> orderDetailList;
}
