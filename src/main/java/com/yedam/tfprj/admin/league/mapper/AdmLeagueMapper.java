package com.yedam.tfprj.admin.league.mapper;

import com.yedam.tfprj.admin.league.service.LeagueStatusVO;
import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdmLeagueMapper {

    @Select("select * from league")
    public List<LeagueVO> getLeaugeList();

    // insert league
    public void insertLeague(LeagueVO leagueVO);

    // get league detail
    @Select("select * from league where league_id = #{leagueId}")
    public LeagueVO getLeagueDetail(int leagueId);

    // getLeagueApply
    @Select("select distinct team_id from league_apply where league_id = #{leagueId}")
    public List<LeagueApplyVO> getLeagueApply(int leagueId);

    // getLeagueApplyTeam
    // 리그에 참가한 모든 팀 조회
    @Select("select  distinct t.team_id, t.leader, t.team_name\n" +
            "from    team t, league_apply l\n" +
            "where   t.team_id = l.team_id\n" +
            "and     l.league_id = #{leagueId}")
    public List<TeamVO> getLeagueApplyTeam(int leagueId);

    // setLeagueApplyTeamStatus
    @Update("update league_apply set is_approve = #{status} where team_id = #{teamId} and league_id = #{leagueId}")
    public void setLeagueApplyTeamStatus(int teamId, int leagueId, int status);

    // setLeagueApplyTeamStatus
    @Select("select  count(distinct t.team_id) as \"teamId\"\n" +
            "from    team t, league_apply l\n" +
            "where   t.team_id = l.team_id\n" +
            "and     l.league_id = #{leagueId}\n" +
            "and     t.team_id = #{teamId}\n" +
            "and     l.is_approve = 1805")
    public int getLeagueApplyTeamIsApprove(int teamId, int leagueId);

    @Select("select distinct is_approve from league_apply where league_id = #{leagueId} and team_id = #{teamId}")
    public String getIsApprove(int leagueId, int teamId);


    // 대진표 만들기 버튼 클릭 시 league_status table 에 데이터 값 입력하기
    @Insert("insert into league_status\n" +
            "values (\n" +
            "    seq_league_status.nextVal,\n" +
            "    #{status},\n" +
            "    #{leagueId},\n" +
            "    #{teamId}\n" +
            ")")
    public void insertLeagueStatus(int status, int leagueId, String teamId);


    // league_status table 에서 해당 league 참가하는 팀 불러오기
    @Select("select * from league_status where league_id = #{leagueId}")
    public List<LeagueStatusVO> getLeagueStatus(int leagueId);

}