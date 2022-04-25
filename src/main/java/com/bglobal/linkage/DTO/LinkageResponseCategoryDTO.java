package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseCategoryDTO {
    private String categoryCode;
    private String name;
    private String description;
    private Double lft;
    private Double rgt;
    private Integer sortOrder;
    private Integer state;
    private Integer created;
    private Integer modified;
    private Object tags;

    public LinkageResponseCategoryDTO(LinkageRequestCategoryDTO linkageRequestCategoryDTO) {
        this.categoryCode = linkageRequestCategoryDTO.getCommonCode();
        this.name = linkageRequestCategoryDTO.getName();
    }
}
