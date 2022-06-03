package com.yedam.tfprj.client.reservation.mapper;

import com.yedam.tfprj.admin.reservation.service.MemberGameVO;
import com.yedam.tfprj.client.game.service.Game;
import com.yedam.tfprj.client.payment.service.PaymentVO;
import com.yedam.tfprj.client.reservation.service.GameVO;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReservationMapper {
    public List<Reservation> findReservation();

    public List<Reservation> findMemberReservation(String memberId);

    public int insertReservation(Reservation rsv);

    public int updateReservation(Reservation rsv);

    public int deleteReservation(Reservation rsv);

    public List<Reservation> reservationCheck(String date, String room);

    public List<String> teamList();

    // 최근 등록한 reservation 정보 들고오기
    @Select("select * from reservation where res_id = (select max(res_id) from reservation)")
    public Reservation getLastReservation();

    // insert game
    @Insert("insert into game (GAME_ID, RES_ID, MEMBER_ID, MEMBER_NAME, INNINGS, HOME_PLAYTEAM_CD, AWAY_PLAYTEAM_CD, ROOM) values (seq_game.nextval, #{resId}, #{memberId}, #{memberName}, #{innings}, #{homePlayteamCd}, #{awayPlayteamCd}, #{room})")
    public void insertGameInReservation(Map<String, String> p);

    @Select("select * from game where game_id = (select max(game_id) from game)")
    public GameVO getLastGameId();

    // insert member-game
    @Insert("insert into member_game (member_id, member_name, ground_cd, difficulty_cd, game_id, res_date)\n" +
            "values (\n" +
            "        #{memberId},\n" +
            "        #{memberName},\n" +
            "        #{groundCd},\n" +
            "        #{difficultyCd},\n" +
            "        #{gameId},\n" +
            "        current_date\n" +
            "        )")
    public void insertMemberGameInReservation(Map<String, String> p);

    // 가장 최근 입력한 payment 건 id 호출
    @Select("select * from payment where payment_id = (select max(payment_id) from payment)")
    public PaymentVO getLastPayment();

    // reservation payment_id update 처리
    @Update("update reservation set payment_id = #{payId} where res_id = #{resId}")
    public void setResPayment(int payId, int resId);

    // select game by game_id
    @Select("select * from game where game_id = #{gameId}")
    public GameVO getGameVoByGameId(int gameId);

    // select reservation by resId
    @Select("select * from reservation where res_id = #{resId}")
    public Reservation getResByResId(int resId);

    // payment insert 처리
    @Insert("insert into payment values (\n" +
            "                    SEQ_PAYMENT.nextVal,\n" +
            "                    current_date,\n" +
            "                    #{paymentAmount},\n" +
            "                    #{prodInfoCd},\n" +
            "                    #{memberId},\n" +
            "                    #{paymentMethodCd},\n" +
            "                    #{paymentStatusCd}\n" +
            "                    )")
    public void insertResPayment(PaymentVO vo);


    // reservation table 에서 resId 건 예약 delete
    @Delete("delete from reservation where res_id = #{resId}")
    public void deleteResById(int resId);

    // game table 에서 gameId 건 delete
    @Delete("delete from game where game_id = #{gameId}")
    public void deleteGameById(int gameId);

    // member-game table 에서 gameId 해당 건 delete
    @Delete("delete from member_game where game_id = #{gameId}")
    public void deleteMemberGameByGameId(int gameId);


}
