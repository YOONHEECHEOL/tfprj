package com.yedam.tfprj.admin.reservation.mapper;

import com.yedam.tfprj.admin.reservation.service.AdmGameVO;
import com.yedam.tfprj.admin.reservation.service.MemberGameVO;
import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdmReservationMapper {
    //전체 리스트
    public List<ReservationVO> resList();
    //start_time 조건 전체리스트
    public List<ReservationVO> dayResList(String startStr);

    public int updatePaymentCd(String resId);

    public AdmGameVO gameInfo(String resId);

    public List<MemberGameVO> homeTeamList(String resId);

    public List<MemberGameVO> awayTeamList(String resId);

    public ReservationVO resInfo(String resId);

    //아이디 비밀번호 맞을 시 1 return
    public String checkId(String memberId, String password, String memberName);

    //아이디 업데이트
    public int updateId(String memberId, String memberName, String gameId );

    public int updateGameStatus(String resId);

    public int updatePaidStatus(String resId);



}
