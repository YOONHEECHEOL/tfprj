package com.yedam.tfprj.admin.sales.Service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    public List<PaymentVO> paymentList(PaymentVO vo);
    public List<Map<String, Object>> findMemNonMem(PaymentVO vo);
    public List<Map<String, Object>> findPayType(PaymentVO vo);
    public List<Map<String, Object>> avgSalesByDay(PaymentVO vo);
    public List<Map<String, Object>> todaySell();
}
