package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MPOSAuthorizeDTO {
    private String accessToken;
    private String refreshToken;
    private Integer expiresIn;
    private List<String> scope;
}
