package com.bglobal.linkage.entity;

import com.bglobal.linkage.support.UserRoleId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "lk_user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @JsonBackReference
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
