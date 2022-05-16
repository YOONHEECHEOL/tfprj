package com.yedam.tfprj.client.common.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    //ClientVO selectClient(ClientVO vo); //단일 리스트
    int insertClient(MemberVO vo);
}
