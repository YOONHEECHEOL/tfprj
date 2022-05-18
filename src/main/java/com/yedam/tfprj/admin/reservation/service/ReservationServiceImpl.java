package com.yedam.tfprj.admin.reservation.service;

import com.yedam.tfprj.admin.reservation.mapper.AdmReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationSevice{

    @Autowired
    AdmReservationMapper mapper;

    @Override
    public List<ReservationVO> resList() {
        return mapper.resList();
    }


}
