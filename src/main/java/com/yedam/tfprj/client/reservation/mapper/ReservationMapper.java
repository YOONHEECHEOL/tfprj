package com.yedam.tfprj.client.reservation.mapper;

import com.yedam.tfprj.client.reservation.service.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<Reservation> findReservation();
    int insertReservation(Reservation rsv);
    int updateReservation(Reservation rsv);
    int deleteReservation(Reservation rsv);
}
