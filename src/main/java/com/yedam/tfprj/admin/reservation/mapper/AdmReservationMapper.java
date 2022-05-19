package com.yedam.tfprj.admin.reservation.mapper;

import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdmReservationMapper {
    //전체 리스트
    public List<ReservationVO> resList();
    //start_time 조건 전체리스트
    public List<ReservationVO> dayResList(String startStr);


}
