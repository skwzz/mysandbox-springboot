package com.kidol.domain.member.dto;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private Long memberId;
    private String email;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
