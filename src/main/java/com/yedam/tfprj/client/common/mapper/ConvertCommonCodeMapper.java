package com.yedam.tfprj.client.common.mapper;

import com.yedam.tfprj.client.common.service.CodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ConvertCommonCodeMapper {

    @Select("select * from common_code where code_name = #{code}")
    public CodeVO convertCode(String code);

}
