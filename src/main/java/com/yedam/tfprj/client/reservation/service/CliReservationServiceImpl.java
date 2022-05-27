package com.yedam.tfprj.client.reservation.service;

import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CliReservationServiceImpl implements CliReservationService {

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public List<Reservation> findReservation() {
        return null;
    }

    @Override
    public Reservation findMemberReservation(Reservation rsv, HttpServletRequest request) {
        HttpSession session = request.getSession();
        rsv.setMemberId((String) (session.getAttribute("memberId")));
        rsv = reservationMapper.findMemberReservation(rsv);
        return rsv;
    }

    @Override
    public int insertReservation(Reservation rsv) {
        return 0;
    }

    @Override
    public int updateReservation(Reservation rsv) {
        return 0;
    }

    @Override
    public int deleteReservation(Reservation rsv) {
        return 0;
    }

    @Override
    public List<Reservation> reservationCheck(String date,String room) {
        return reservationMapper.reservationCheck(date, room);
    }
}
