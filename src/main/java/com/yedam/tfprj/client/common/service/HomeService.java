package com.yedam.tfprj.client.common.service;

import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import com.yedam.tfprj.client.league.service.LeagueVO;

import java.util.List;
import java.util.Map;

public interface HomeService {

  // 현재 예약가능 여부 확인
  public List<Map<String, String>> chkResNow();

  // 공지사항 최신 3개 출력
  // 전체 선택 후 3개만 출력
  public List<CliNoticeVO> getHomeNoticeList();

  // 현재 진행 중인 리그
  public List<LeagueVO> getHomeLeagueList();


}
