package com.bglobal.linkage.DTO;

import com.bglobal.linkage.entity.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseLoginDTO {
    private String roleId;
    private String serviceId;
    private String sessionId;
    private String userId;

    public ResponseLoginDTO(User user) {
        this.roleId = "";
        this.serviceId = user.getService().getId().toString();
        this.sessionId = "";
        this.userId = user.getId().toString();
    }
}
