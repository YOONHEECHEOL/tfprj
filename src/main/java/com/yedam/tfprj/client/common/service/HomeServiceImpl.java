package com.yedam.tfprj.client.common.service;

import com.yedam.tfprj.client.community.mapper.CliNoticeMapper;
import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import com.yedam.tfprj.client.league.service.CliLeagueServiceImpl;
import com.yedam.tfprj.client.league.service.LeagueService;
import com.yedam.tfprj.client.league.service.LeagueVO;
import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService{

  @Autowired
  ReservationMapper reservationMapper;

  @Autowired
  CliNoticeMapper cliNoticeMapper;

  @Autowired
  LeagueService cliLeagueService;

  @Override
  public List<Map<String, String>> chkResNow() {

    List<Map<String, String>> returnVal = new ArrayList<>();

    for(int i=1; i<5; i++) {
      Map<String, String> chkResult = new HashMap<>();
      String rs = reservationMapper.getIsResNow(i);
      if(rs == null) {
        rs = "y";
      } else {
        rs = "n";
      }
      chkResult.put("chk", rs);
      returnVal.add(chkResult);
    }

    return returnVal;
  }

  // 공지사항 반환
  @Override
  public List<CliNoticeVO> getHomeNoticeList() {
    return cliNoticeMapper.getNoticeList();
  }


  @Override
  public List<LeagueVO> getHomeLeagueList() {
    return cliLeagueService.getLeagueListForHome();
  }
}
