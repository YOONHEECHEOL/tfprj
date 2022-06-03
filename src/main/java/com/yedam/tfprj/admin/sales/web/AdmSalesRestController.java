package com.yedam.tfprj.admin.sales.web;

import com.yedam.tfprj.admin.sales.Service.PaymentServiceImpl;
import com.yedam.tfprj.admin.sales.Service.AdmPaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdmSalesRestController {
    @Autowired
    PaymentServiceImpl service;

    @RequestMapping("/adm/searchSales")
    public List<AdmPaymentVO> searchSales(AdmPaymentVO vo) {
        System.out.println("요일확인" + vo);
        return service.paymentList(vo);
    }

    @RequestMapping("/adm/findMemNonMem")
    public List<Map<String, Object>> findMemNonMem(AdmPaymentVO vo){
        return service.findMemNonMem(vo);
    }

    @RequestMapping("/adm/findPayType")
    public List<Map<String, Object>> findPayType(AdmPaymentVO vo){
        return service.findPayType(vo);
    }

    @RequestMapping("/adm/avgSalesByDay")
    public List<Map<String, Object>> avgSalesByDay(AdmPaymentVO vo){
        return service.avgSalesByDay(vo);
    }

    @RequestMapping("/adm/todaySell")
    public List<Map<String, Object>> todaySell(){
        return service.todaySell();
    }
}
