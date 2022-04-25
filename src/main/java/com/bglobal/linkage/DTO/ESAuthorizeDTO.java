package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ESAuthorizeDTO {
    private String clientId;
    private String clientSecret;
    private String scope;
    private String sessionId;
    private String refreshToken;
}
