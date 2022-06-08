package com.yedam.tfprj.admin.reservation.service;

import java.util.List;

public interface ReservationService {
    public String jsonResList();

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
