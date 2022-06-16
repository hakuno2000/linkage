package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseTableActivityDTO {
    private String tableActivityCode;
    private Integer fromTableActivityCode;
    private Integer towardTableActivityCode;
    private Integer tableActivityState;
    private String tableCode;
    private Integer tableActivityCustomerNumber;
    private Integer tableActivityCreated;
    private Integer tableActivityModified;
    private Double tax;
    private Double subtotal;
    private Double subtotalTaxNon;
    private Double subtotalTaxNormal;
    private Double subtotalTaxReduced;
    private Double total;
    private Double totalTaxNon;
    private Double totalTaxNormal;
    private Double totalTaxReduced;
    private Integer discountValue;
    private Integer discountPercent;
    private Integer discountType;
}
