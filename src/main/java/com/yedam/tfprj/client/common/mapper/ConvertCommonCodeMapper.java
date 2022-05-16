package com.yedam.tfprj.client.common.mapper;

import com.yedam.tfprj.client.common.service.CodeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConvertCommonCodeMapper {

    public String convertCode(CodeVO code);

}
