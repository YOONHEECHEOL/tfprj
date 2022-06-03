package com.yedam.tfprj.admin.sales.Service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    public List<AdmPaymentVO> paymentList(AdmPaymentVO vo);
    public List<Map<String, Object>> findMemNonMem(AdmPaymentVO vo);
    public List<Map<String, Object>> findPayType(AdmPaymentVO vo);
    public List<Map<String, Object>> avgSalesByDay(AdmPaymentVO vo);
    public List<Map<String, Object>> todaySell();
}
