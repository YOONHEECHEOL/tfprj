package com.yedam.tfprj.admin.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdmLeagueMapper {

    @Select("select * from league")
    public List<LeagueVO> getLeaugeList();

}
