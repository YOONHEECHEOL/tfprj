package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class LeagueServiceVO {

    private List<LeagueVO> currentList;
    private List<LeagueVO> passedList;
    protected MemberVO loginedMember;
    protected LeagueVO leagueVO;
    protected TeamVO teamVO;

    public LeagueServiceVO() {
        this.loginedMember = new MemberVO();
    }

    public LeagueServiceVO(LeagueVO leagueVO) {
        this.leagueVO = new LeagueVO();
    }

    public LeagueServiceVO(TeamVO teamVO) {
        this.teamVO = new TeamVO();
    }
}
