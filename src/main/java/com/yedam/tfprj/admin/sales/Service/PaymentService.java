package com.yedam.tfprj.admin.sales.Service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    public List<PaymentVO> paymentList(PaymentVO vo);
    public List<Map<String, Object>> findMemNonMem();
}
