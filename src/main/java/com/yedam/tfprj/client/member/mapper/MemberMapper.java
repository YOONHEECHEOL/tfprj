package com.yedam.tfprj.client.member.mapper;

import com.yedam.tfprj.client.common.mapper.MemberVO;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //멤버 전체 조회
    public List<MemberVO> findAll();
    //멤버 단건 조회
    public MemberVO findOne(MemberVO vo);
 
}
