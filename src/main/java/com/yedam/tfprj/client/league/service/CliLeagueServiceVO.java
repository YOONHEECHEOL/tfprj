package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import lombok.Data;

import java.util.List;

@Data
public class CliLeagueServiceVO {

    private List<LeagueVO> currentList;
    private List<LeagueVO> passedList;
    protected List<MemberVO> teamMembers;
    protected MemberVO loginedMember;
    protected LeagueVO leagueVO;
    protected TeamVO teamVO;
    private LeagueApplyVO leagueApplyVO;
    private List<LeagueVO> participatedLeague;
    private List<LeagueVO> notParticipatedLeague;

    public CliLeagueServiceVO() {
        this.loginedMember = new MemberVO();
    }

    public CliLeagueServiceVO(LeagueVO leagueVO) {
        this.leagueVO = new LeagueVO();
    }

    public CliLeagueServiceVO(TeamVO teamVO) {
        this.teamVO = new TeamVO();
    }
}
