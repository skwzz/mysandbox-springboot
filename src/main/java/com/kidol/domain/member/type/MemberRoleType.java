package com.kidol.domain.member.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum MemberRoleType {

    MEMBER_ROLE_A("admin"),
    MEMBER_ROLE_B("user");

    private String memberRole;
}
