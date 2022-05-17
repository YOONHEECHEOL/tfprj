package com.yedam.tfprj.client.common.service;

import com.yedam.tfprj.client.common.mapper.ConvertCommonCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertCommonCodeServiceImpl implements ConvertCommonCodeService {

    @Autowired
    ConvertCommonCodeMapper convertCommonCodeMapper;

    @Override
    public CodeVO convertCode(String code) {
        return convertCommonCodeMapper.convertCode(code);
    }
}
