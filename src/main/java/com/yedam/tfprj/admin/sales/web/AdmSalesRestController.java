package com.yedam.tfprj.admin.sales.web;

import com.yedam.tfprj.admin.sales.Service.PaymentServiceImpl;
import com.yedam.tfprj.admin.sales.Service.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdmSalesRestController {
    @Autowired
    PaymentServiceImpl service;

    @RequestMapping("/adm/searchSales")
    public List<PaymentVO> searchSales(PaymentVO vo) {
        System.out.println("요일확인" + vo);
        return service.paymentList(vo);
    }

    @RequestMapping("/adm/findMemNonMem")
    public List<Map<String, Object>> findMemNonMem(PaymentVO vo){
        return service.findMemNonMem(vo);
    }

    @RequestMapping("/adm/findPayType")
    public List<Map<String, Object>> findPayType(PaymentVO vo){
        return service.findPayType(vo);
    }

    @RequestMapping("/adm/avgSalesByDay")
    public List<Map<String, Object>> avgSalesByDay(PaymentVO vo){
        return service.avgSalesByDay(vo);
    }
}
