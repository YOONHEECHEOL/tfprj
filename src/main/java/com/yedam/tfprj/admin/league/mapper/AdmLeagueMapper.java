package com.yedam.tfprj.admin.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdmLeagueMapper {

    @Select("select * from league")
    public List<LeagueVO> getLeaugeList();

    // insert league
    public void insertLeague(LeagueVO leagueVO);

    // get league detail
    @Select("select * from league where league_id = #{lno}")
    public LeagueVO getLeagueDetail(int lno);

    // getLeagueApply
    @Select("select * from league_apply where league_id = #{leagueId}")
    public List<LeagueApplyVO> getLeagueApply(int leagueId);

}