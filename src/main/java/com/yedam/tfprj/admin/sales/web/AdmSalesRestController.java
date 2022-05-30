package com.yedam.tfprj.admin.sales.web;

import com.yedam.tfprj.admin.sales.Service.PaymentServiceImpl;
import com.yedam.tfprj.admin.sales.Service.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdmSalesRestController {
    @Autowired
    PaymentServiceImpl service;

    @RequestMapping("/adm/searchSales")
    public List<PaymentVO> searchSales(@RequestParam String firstDate, @RequestParam String lastDate) {
        PaymentVO vo = new PaymentVO();

        vo.setFirstDate(firstDate);
        vo.setLastDate(lastDate);

        System.out.println("날짜" + service.paymentList(vo));
        return service.paymentList(vo);
    }

    @RequestMapping("/adm/findMemNonMem")
    public List<Map<String, Object>> findMemNonMem(){
        return service.findMemNonMem();
    }
}
