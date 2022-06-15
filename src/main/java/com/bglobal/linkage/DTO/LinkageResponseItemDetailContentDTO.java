package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseItemDetailContentDTO {
    private String itemCode;
    private String itemDetailCode;
    private String itemDetailContentCode;
    private String name;
    private Integer price;
    private Integer priceTaxIn;
    private Double tax;
    private Integer state;
    private Integer sortOrder;
    private Integer created;
    private Integer modified;

    public LinkageResponseItemDetailContentDTO(LinkageRequestItemDetailContentDTO itemDetailContent) {
        this.itemCode = itemDetailContent.getItemCode();
        this.itemDetailCode = itemDetailContent.getItemDetailCode();
        this.itemDetailContentCode = itemDetailContent.getItemDetailContentCode();
        this.name = itemDetailContent.getName();
        if (itemDetailContent.getPrice() != null) this.price = itemDetailContent.getPrice().intValue(); else this.price = null;
        if (itemDetailContent.getPriceTaxIn() != null) this.priceTaxIn = itemDetailContent.getPriceTaxIn().intValue(); else this.priceTaxIn = null;
        if (itemDetailContent.getPrice() != null && itemDetailContent.getPriceTaxIn() != null) this.tax = itemDetailContent.getPriceTaxIn() - itemDetailContent.getPrice(); else this.tax = null;
        this.state = itemDetailContent.getState();
        this.sortOrder = itemDetailContent.getSortOrder();
        this.created = itemDetailContent.getCreated();
        this.modified = itemDetailContent.getModified();
    }
}
