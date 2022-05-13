package com.yedam.tfprj.client.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface LeagueMapper {

    public List<LeagueVO> getLeagueList();

}
