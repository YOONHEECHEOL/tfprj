package com.yedam.tfprj.client.reservation.service;

import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Reservation> findMemberReservation(Reservation rsv, HttpServletRequest request) {
        HttpSession session = request.getSession();

        String memberId = session.getAttribute("memberId").toString();

        return reservationMapper.findMemberReservation(memberId);
    }

    @Override
    public int insertReservation(Reservation rsv) {

        return reservationMapper.insertReservation(rsv);
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

    @Override
    public List<String> teamList() {
        return reservationMapper.teamList();
    }

    @Override
    public void deleteReservation() {

    }
}
