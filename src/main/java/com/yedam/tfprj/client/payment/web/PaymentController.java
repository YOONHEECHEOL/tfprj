package com.yedam.tfprj.client.payment.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PaymentController {

    @RequestMapping("/cli/payment/pay")
    public String cliPay(){return "client/payment/pay";}

    @RequestMapping("/cli/payment/payDone")
    public String cliRes(){return "client/payment/pay_done";}

}
