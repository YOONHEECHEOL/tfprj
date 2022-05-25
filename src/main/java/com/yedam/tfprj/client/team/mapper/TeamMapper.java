package com.yedam.tfprj.client.team.mapper;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper {

    // 단건조회
    @Select("select * from team where team_id = #{teamId}")
    public TeamVO selectTeam(int teamId);

    public int createTeam(TeamVO vo);

    public TeamVO findTeam(TeamVO vo);

    @Select("select * from member where team_id = #{teamId}")
    public List<MemberVO> selectTeamMembers(int teamId);
    
    //전체조회
    public List<TeamVO> teamAll();
}
