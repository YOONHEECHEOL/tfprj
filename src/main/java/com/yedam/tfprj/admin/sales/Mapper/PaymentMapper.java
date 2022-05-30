package com.yedam.tfprj.admin.sales.Mapper;

import com.yedam.tfprj.admin.sales.Service.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {
    public List<PaymentVO> paymentList(PaymentVO vo);
    public List<Map<String, Object>> findMemNonMem();
}
