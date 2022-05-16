package com.yedam.tfprj.client.common.web;

import com.yedam.tfprj.client.common.service.CodeVO;
import com.yedam.tfprj.client.common.service.ConvertCommonCodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    ConvertCommonCodeService convertCommonCodeServiceImpl;

    @RequestMapping("/")
    public String toHome() {
        return "client/common/home";
    }

    @RequestMapping(value = "/convertCommonCode", method = RequestMethod.POST)
    @ResponseBody
    public String convertCommonCode(@RequestBody CodeVO code) {

        return convertCommonCodeServiceImpl.convertCode(code);
    }

}
