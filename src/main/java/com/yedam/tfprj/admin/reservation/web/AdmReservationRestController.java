package com.yedam.tfprj.admin.reservation.web;

import com.yedam.tfprj.admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdmReservationRestController {
    @Autowired
    ReservationService reservationServiceImpl;

    @GetMapping("/adm/reservation/reservation_list")
    public String CalendarJson() {

        return reservationServiceImpl.jsonResList();
    }

    @PostMapping("/adm/reservation/update_payment_cd")
    public int UpdatePaymentCd(@RequestParam String resId){
        reservationServiceImpl.updatePaymentCd(resId);
        return 1;
    }

    @PostMapping("/adm/reservation/checkId")
    public String checkIdAndUpdate(@RequestParam String memberId, @RequestParam String password,  @RequestParam String memberName, @RequestParam String gameId){
        if(reservationServiceImpl.checkId(memberId,password,memberName).equals("0") ){
            return "0";
        }else{
            reservationServiceImpl.updateId(memberId, memberName, gameId);
            System.out.println("ID 업데이트 완료");
            return "ID 업데이트 완료";
        }
    }


}
