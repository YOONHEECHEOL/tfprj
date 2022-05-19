package com.yedam.tfprj.client.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliLeagueMapper {

    public List<LeagueVO> getLeagueList();

    public LeagueVO getLeagueDetail(int lno);

}
