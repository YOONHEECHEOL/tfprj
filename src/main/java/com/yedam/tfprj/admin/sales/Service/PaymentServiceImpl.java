package com.yedam.tfprj.admin.sales.Service;

import com.yedam.tfprj.admin.sales.Mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper mapper;

    @Override
    public List<PaymentVO> paymentList(PaymentVO vo) {
        return mapper.paymentList(vo);
    }

    @Override
    public List<Map<String, Object>> findMemNonMem(PaymentVO vo) {
        return mapper.findMemNonMem(vo);
    }

    @Override
    public List<Map<String, Object>> findPayType(PaymentVO vo) {
        return mapper.findPayType(vo);
    }

    @Override
    public List<Map<String, Object>> avgSalesByDay(PaymentVO vo) {
        return mapper.avgSalesByDay(vo);
    }

    @Override
    public List<Map<String, Object>> todaySell() {
        return mapper.todaySell();
    }
}
