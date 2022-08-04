package com.kidol.domain.member.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequest {

    private Long memberId;
    private String email;
    private String name;
    private String password;
}
