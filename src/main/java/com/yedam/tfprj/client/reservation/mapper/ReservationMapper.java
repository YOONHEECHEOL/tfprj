package com.yedam.tfprj.client.reservation.mapper;

import com.yedam.tfprj.client.reservation.service.Reservation;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReservationMapper {
    public List<Reservation> findReservation();
    public Reservation findMemberReservation(Reservation rsv);
    public int insertReservation(Reservation rsv);
    public int updateReservation(Reservation rsv);
    public int deleteReservation(Reservation rsv);

    public List<Reservation>  reservationCheck(String date,String room);


}
