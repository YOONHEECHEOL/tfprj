package com.yedam.tfprj.client.payment.service;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentVO {

    private int paymentId;
    private Date paymentDate;
    private int paymentAmount;
    private String prodInfoCd;
    private String memberId;
    private String paymentMethodCd;
    private String paymentStatusCd;
}
