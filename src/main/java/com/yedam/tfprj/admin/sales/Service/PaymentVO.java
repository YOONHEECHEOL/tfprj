package com.yedam.tfprj.admin.sales.Service;

import lombok.Data;

@Data
public class PaymentVO {
    private int paymentId;
    private String paymentDate;
    private int paymentAmount;
    private int prodInfoCd;
    private String memberId;
    private int paymentMethodCd;
    private int paymentStatusCd;

    private String firstDate;
    private String lastDate;
    private String day;
    private String pay;

    private int sum;
    private int count;
    private String member;

}
