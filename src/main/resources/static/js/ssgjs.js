
//데이트피커 설정
$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});
//데이트피커 버튼 클릭 이벤트
$(function() {
    $("#rsvBtn").datepicker({
        onSelect: function(){
            var date = $("#rsvBtn").datepicker("getDate");
            date = $("#rsvBtn").val();
            $("#dateVal").val(date);
            date = $("#dateVal").val();
            console.log(date);
            $("#rsvBtn").val("날짜변경");
            let room = $("#room").text();
            removeClass();
            reservedTimeCheck(date,room)
        }
    });
});
//client 예약 목록 전체 조회
 function reservationList(){
     $.ajax({
         url : '/reservationList'
     }).done(function (data){
                 console.log(data);
     })
 }

 //예약시간 데이트 체크
function reservedTimeCheck(date, room){
    $.ajax({
        url : "reservationCheck",
        data : {
            date : date,
            room : room
        }
    }).done(function(response){
        console.log($("#21").text());
        console.log(response)
        for(let i = 0; i < response.length;i++){



            let startTime = response[i].startTime;
            let endTime = response[i].endTime;
            let st = startTime.substring(11,13);
            let et = endTime.substring(11,13);
            let gameTime = et-st;
            console.log(st, et);
            console.log(gameTime);
            for(let j =10; j<=24; j++){
                if(st == j){
                    if(gameTime>1){
                        for(let k=0; k<=gameTime-1;k++){
                            console.log("야야")
                            console.log(j+k);

                            console.log($('#'+(j+k)).text());
                            $('#'+(j+k)).attr('class',"btn btn-danger")
                        }

                    }else{
                        console.log("야야야")
                        $('#'+(j)).attr('class',"btn btn-danger")
                    }


                }
            }



        }


    })

}
function next(){
    var date = $("#dateVal").val()


    var roomNo = parseInt($('#room').text());
    if(roomNo <4){
        $('#room').text(roomNo + 1);
        var room = parseInt($('#room').text());
        removeClass();
        reservedTimeCheck(date, room)
    }

}

function prev(){
    var date = $("#dateVal").val()


    let roomNo = parseInt($('#room').text());
    if(roomNo >1){
        $('#room').text(roomNo - 1);
        var room = parseInt($('#room').text());
        removeClass();
        reservedTimeCheck(date, room)
    }

}

function removeClass(){
    for(let j =10; j<=24; j++){
        $('#'+(j)).removeClass();
    }
}

function clickTimetable(startTime){
    var buttonList = $("button");
    let successClassList = document.getElementsByClassName("btn btn-success");
    let reservedClassList = document.getElementsByClassName("btn btn-danger");
    let reservedTimeList=[];
    let clickedTimeList = [];

    for(let i=0; i<successClassList.length;i++){
        var id = successClassList[i].getAttribute('id');
        clickedTimeList.push(id);
    }

    for(let i = 0; i<reservedClassList.length;i++){
        var id = reservedClassList[i].getAttribute('id');
        reservedTimeList.push(id);

    }
    console.log("예약된 시간임 : " + reservedTimeList);
    console.log("클릭된 시간임 : " + clickedTimeList);

     console.log(successClassList)
     if(successClassList.length >0){
         alert("한개 이상 있다" + successClassList.length + "개")
         
     }else if(successClassList.length === 0){
         alert("한개도 없었다" + successClassList.length + "개")
     }
    var timeClass = $('#'+(startTime)).attr('class');
    console.log(timeClass);


    if(timeClass == 'btn btn-danger') {
        alert("이미 예약된 시간입니다")
    }else if(timeClass == 'btn btn-success') {
        $('#' + (startTime)).removeClass();
    }
    else{
        $('#'+(startTime)).attr('class','btn btn-success')

    }

}

function check



