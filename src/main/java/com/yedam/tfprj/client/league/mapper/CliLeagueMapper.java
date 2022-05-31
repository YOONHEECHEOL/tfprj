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
            "and team_id = #{teamId}\n" +
            "and member_id = #{memberId}")
    public String isLeagueApplyStatus(int leagueId, String teamId, String memberId);

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

    // league apply 건에 pay 처리
    @Update("update league_apply set is_approve = 1803 where league_id = #{leagueId} and team_id = #{teamId}")
    public void payLeague(int leagueId, int teamId);

    // league_apply 정보 가져오기
    @Select("select distinct team_member\n" +
            "from league_apply\n" +
            "where   league_id = #{leagueId}\n" +
            "and     team_id = #{teamId}")
    public String getLeagueApplyTeamMember(int leagueId, String teamId);


    // payement 테이블에 결제정보 입력
    @Select("insert into payment values (\n" +
            "                            SEQ_PAYMENT.nextval,\n" +
            "                            current_date,\n" +
            "                            #{payAmount},\n" +
            "                            '1506',\n" +
            "                            #{memberId},\n" +
            "                            '1701',\n" +
            "                            '802'\n" +
            "                            )")
    public void insertLeaguePayment(int payAmount, String memberId);

}
