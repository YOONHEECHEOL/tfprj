select * from tab;

select * from league;

drop sequence seq_leauge;
drop sequence seq_tournament;
drop sequence seq_reservation;

create sequence seq_league
    START with 1
    INCREMENT by 1;

create sequence seq_team
    START with 1
    INCREMENT by 1;

create sequence seq_tournament
    START with 1
    INCREMENT by 1;

create sequence seq_reservation
    START with 1
    INCREMENT by 1;

select * from common_code;

insert into league
values (
           SEQ_LEAGUE.nextval,
           '추계 리그',
           '2022/05/02',
           '2022/05/03',
           '2022/05/06',
           500000,
           8,
           'NFT-TROPHY',
           null,
           '501',
           1,
           5000
       );

insert into tournament
values (
           SEQ_TOURNAMENT.nextval,

       );

select * from member;

--(
--         select count(g.playteam_cd), c.code_name
--         from geme g, member m, common_code c
--         where g.member_id = m.member_id
--         and g.playteam_cd = c.code_name(+)
--         group by c.code_name;
--        )

alter table member
    modify (member_name varchar2(100));

insert into member
values (
           'lee',
           'lee eun',
           '010-2333-1555',
           '301',
           '1234',
           0,
           null,
           null,
           null,
           1
       );

select * from member;
desc member;

select * from team;

insert into team
values (
           SEQ_TEAM.nextval,
           'lee',
           0,
           0,
           0,
           '맛없는 사슴'
       );

select league_id
from league;


commit;

select * from notice_board;
insert into notice_board
values (2, 'test',sysdate, 1, 'hello world!');

desc notice_board;