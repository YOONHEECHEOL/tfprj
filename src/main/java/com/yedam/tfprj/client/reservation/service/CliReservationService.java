package com.yedam.tfprj.client.reservation.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CliReservationService {
    public List<Reservation> findReservation();
    public List<Reservation> findMemberReservation(Reservation rsv, HttpServletRequest request);


    int insertReservation(Reservation rsv);

    public int updateReservation(Reservation rsv);
    public int deleteReservation(Reservation rsv);

    //예약된 날짜 시간 조회
    public List<Reservation>  reservationCheck(String date, String room);

    public List<String> teamList();
}
