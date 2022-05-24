package com.yedam.tfprj.client.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CliLeagueMapper {

    public List<LeagueVO> getLeagueList();

    public LeagueVO getLeagueDetail(int lno);

    // 리그 참가
    public void submitLeagueApply(LeagueApplyVO leagueApplyVO);

    // league_apply table 에 등록되어있는지 조회
    public List<LeagueApplyVO> isLeagueApply(LeagueApplyVO leagueApplyVO);

    // league is_approve 상태 확인
    @Select("select distinct is_approve from league_apply where league_id = #{leagueId}")
    public String isLeagueApplyStatus(int leagueId);
}
