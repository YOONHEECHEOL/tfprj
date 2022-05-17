package com.yedam.tfprj.admin.reservation.mapper;

import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdmReservationMapper {
    public List<ReservationVO> resList();


}
