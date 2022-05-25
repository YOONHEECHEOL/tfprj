package com.yedam.tfprj.client.community.mapper;

import com.yedam.tfprj.client.community.service.faq.CliFaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliFaqMapper {
    public List<CliFaqVO> CliFaqList(CliFaqVO vo);
}
