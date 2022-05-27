package com.yedam.tfprj.client.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select distinct is_approve\n" +
            "from league_apply\n" +
            "where league_id = #{leagueId}\n" +
            "and team_id = #{teamId}")
    public String isLeagueApplyStatus(int leagueId, String teamId);

    @Select("select team_id from member where member_id = #{memberId}")
    public String selectTeamId(String memberId);

    // cancel league apply
    @Update("update  league_apply\n" +
            "set     is_approve = 1802\n" +
            "where   team_id = #{teamId}\n" +
            "and     league_id = #{leagueId}")
    public void cancelLeagueApply(int teamId, int leagueId);


    // teamId 얻기
    @Select("select team_id from member where member_id = #{memberId}")
    public int getTeamId(String memberId);

}
