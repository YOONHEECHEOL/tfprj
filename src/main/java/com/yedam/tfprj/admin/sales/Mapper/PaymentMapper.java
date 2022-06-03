package com.yedam.tfprj.admin.sales.Mapper;

import com.yedam.tfprj.admin.sales.Service.AdmPaymentVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {
    public List<AdmPaymentVO> paymentList(AdmPaymentVO vo);
    @MapKey("String")
    public List<Map<String, Object>> findMemNonMem(AdmPaymentVO vo);
    @MapKey("String")
    public List<Map<String, Object>> findPayType(AdmPaymentVO vo);
    @MapKey("String")
    public List<Map<String, Object>> avgSalesByDay(AdmPaymentVO vo);
    @MapKey("String")
    public List<Map<String, Object>> todaySell();
}
