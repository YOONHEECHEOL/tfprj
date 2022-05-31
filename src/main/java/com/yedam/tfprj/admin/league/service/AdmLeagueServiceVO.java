package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import lombok.Data;

import java.util.List;

@Data
public class AdmLeagueServiceVO {

    protected List<LeagueVO> currentList;
    protected List<LeagueVO> passedList;
    protected MemberVO loginedMember;
    protected LeagueVO leagueVO;
    protected TeamVO teamVO;
    private List<LeagueApplyVO> leagueApplyVOList;
    private List<TeamVO> leagueApplyTeam;
    private List<TeamVO> leagueApplyApproveTeam;
    private List<LeagueStatusVO> leagueStatusTeamList;

}
