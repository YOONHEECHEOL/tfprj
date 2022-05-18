package com.yedam.tfprj.client.team.mapper;

import com.yedam.tfprj.client.team.service.TeamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeamMapper {

    // 단건조회
    @Select("select * from team where team_id = #{teamId}")
    public TeamVO selectTeam(int teamId);

}
