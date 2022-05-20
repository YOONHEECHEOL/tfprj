package com.yedam.tfprj.client.league.mapper;

import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliLeagueMapper {

    public List<LeagueVO> getLeagueList();

    public LeagueVO getLeagueDetail(int lno);

    // 리그 참가
    @Insert("insert into league_apply values (seq_league_apply.nextVal, #leagueId, #teamMember, #isApprove, #memberId, #entryFee)")
    public void submitLeagueApply(LeagueApplyVO leagueApplyVO);
}
