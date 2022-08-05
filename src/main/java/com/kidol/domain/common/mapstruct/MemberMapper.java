package com.kidol.domain.common.mapstruct;

import com.kidol.domain.member.dto.MemberRequest;
import com.kidol.domain.member.dto.MemberResponse;
import com.kidol.domain.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper<MemberRequest, MemberResponse, Member> {
}
