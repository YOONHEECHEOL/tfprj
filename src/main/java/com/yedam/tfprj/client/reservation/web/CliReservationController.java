package com.yedam.tfprj.client.reservation.web;

import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.GameVO;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CliReservationController {

  @Autowired
  ReservationMapper reservationMapper;

  @RequestMapping("/cli/reservation/room")
  public String reservation() {
    return "client/reservation/room";
  }

  // insert and return last reservation
  @RequestMapping(value = "/cli/reservation/info", method = RequestMethod.POST)
  public String resInfo(Reservation reservation, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    if (session.getAttribute("memberId") != null) {
      reservation.setMemberId((String) session.getAttribute("memberId"));
    } else {
      reservation.setMemberId("비회원");
    }
    reservationMapper.insertReservation(reservation);

    // 입력된 reservation 으로 정보 받기
    reservation = reservationMapper.getLastReservation();

    model.addAttribute("reservation", reservation);
    return "client/reservation/info";
  }

  //
  @RequestMapping("/cli/reservationList")
  public String findReservationList(Model model) {
    model.addAttribute("rList", reservationMapper.findReservation());
    return "client/reservation/reservationList";
  }

  //
  @RequestMapping("/cli/resPay")
  public String resPay(String resNo, String gameId, Model model) {

    System.out.println(">>>resNo = " + resNo);
    System.out.println(">>>gameId = " + gameId);

    // 예약 Id
    model.addAttribute("res", reservationMapper.getResByResId(Integer.parseInt(resNo)));

    // game Id
    model.addAttribute("game", reservationMapper.getGameVoByGameId(Integer.parseInt(gameId)));

    return "client/reservation/pay";
  }

  @GetMapping("/cli/reservation/reservationCheck")
  @ResponseBody
  public List<Reservation> reservationCheckList(@RequestParam String date, @RequestParam String room) {

    return reservationMapper.reservationCheck(date, room);
  }

  @GetMapping("/cli/reservation/teamList")
  @ResponseBody
  public List<String> teamList() {

    return reservationMapper.teamList();
  }


  // gameInfo 데이터를 받아 insert 처리
  @PostMapping("/cli/insertGame")
  @ResponseBody
  public String insertGame(@RequestBody Map<String, String> vo) {

    System.out.println(">>vo = " + vo);

    reservationMapper.insertGameInReservation(vo);

    return String.valueOf(reservationMapper.getLastGameId().getGameId());
  }

  // memberGameInfo 데이터를 받아 처리
  @PostMapping("/cli/insertMemberGame")
  @ResponseBody
  public String insertMemberGame(@RequestBody Map<String, String> param) {

    reservationMapper.insertMemberGameInReservation(param);

    return "memberGame insert 처리됨";
  }

}
