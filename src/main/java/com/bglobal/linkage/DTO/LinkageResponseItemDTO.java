package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseItemDTO {
    private String itemDetailCode;
    private String categoryCode;
    private String itemCode;
    private String description;
    private String name;
    private Integer price;
    private Integer priceTaxIn;
    private Integer sortOrder;
    private Integer state;
    private Integer stock;
    private Double tax;
    private Integer created;
    private Integer modified;
    private Object tags;

    public LinkageResponseItemDTO(LinkageRequestItemDTO linkageRequestItemDTO) {
        this.itemDetailCode = linkageRequestItemDTO.getItemDetailCode();
        this.categoryCode = linkageRequestItemDTO.getCategoryCode();
        this.itemCode = linkageRequestItemDTO.getCommonCode();
        this.description= linkageRequestItemDTO.getDescription();
        this.name = linkageRequestItemDTO.getName();
        this.price = linkageRequestItemDTO.getPrice().intValue();
        this.priceTaxIn = linkageRequestItemDTO.getPriceTaxIn().intValue();
        this.sortOrder = linkageRequestItemDTO.getSortOrder();
        this.state = linkageRequestItemDTO.getState();
        this.stock = linkageRequestItemDTO.getStock();
        this.tax = linkageRequestItemDTO.getTax();
        this.created = linkageRequestItemDTO.getCreated();
        this.modified = linkageRequestItemDTO.getModified();
    }
}
