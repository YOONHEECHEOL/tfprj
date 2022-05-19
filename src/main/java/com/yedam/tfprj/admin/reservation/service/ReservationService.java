package com.yedam.tfprj.admin.reservation.service;

import java.util.List;

public interface ReservationService {
    public String jsonResList();

    public List<ReservationVO> dayResList(String startStr);


}
