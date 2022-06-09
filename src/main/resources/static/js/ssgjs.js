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
$(function () {
    $("#rsvBtn").datepicker({
        //minDate: 0, //오늘날짜 이후로만 예약 가능하게
        onSelect: function () {
            var date = $("#rsvBtn").datepicker("getDate");
            date = $("#rsvBtn").val();
            $("#dateVal").text(date);
            date = $("#dateVal").text();
            $('#date').val(date);
            console.log(date);
            $("#rsvBtn").val("날짜변경");
            let room = $("#room").text();
            removeClass();
            reservedTimeCheck(date, room)
        }
    });
});


//client 예약 목록 전체 조회
function reservationList() {
    $.ajax({
        url: '/cli/reservation/reservationList'
    }).done(function (data) {
        console.log(data);
    })
}

//예약시간 데이트 체크
function reservedTimeCheck(date, room) {
    $.ajax({
        url: "/cli/reservation/reservationCheck",
        data: {
            date: date,
            room: room
        }
    }).done(function (response) {
        console.log($("#21").text());
        console.log(response)
        for (let i = 0; i < response.length; i++) {
            let startTime = response[i].startTime;
            let endTime = response[i].endTime;
            let st = startTime.substring(11, 13);
            let et = endTime.substring(11, 13);
            let gameTime = et - st;
            let fullEndTime = endTime.substring(11, 16);

            console.log(fullEndTime);
            if (fullEndTime == '23:59') {
                console.log("막타임데스요")
                for (let j = 10; j <= 24; j++) {
                    if (st == j) {
                        if (gameTime > 1) {
                            for (let k = 0; k <= gameTime + 1; k++) {
                                console.log("야야")
                                console.log(j + k);

                                console.log($('#' + (j + k)).text());
                                $('#' + (j + k)).attr('class', "btn-danger")
                            }

                        } else {
                            console.log("야야야")
                            $('#' + (j)).attr('class', "btn-danger")
                        }


                    }
                }

            } else {
                for (let j = 10; j <= 24; j++) {
                    if (st == j) {
                        if (gameTime > 1) {
                            for (let k = 0; k <= gameTime - 1; k++) {
                                console.log("야야")
                                console.log(j + k);

                                console.log($('#' + (j + k)).text());
                                $('#' + (j + k)).attr('class', "btn-danger")
                            }

                        } else {
                            console.log("야야야")
                            $('#' + (j)).attr('class', "btn-danger")
                        }


                    }
                }

            }


        }


    })

}

function next() {
    var date = $("#dateVal").text()


    var roomNo = parseInt($('#room').text());
    if (roomNo < 4) {
        $('#room').text(roomNo + 1);
        $('#roomNo').val(roomNo + 1);
        var room = parseInt($('#room').text());

        removeClass();
        reservedTimeCheck(date, room)
    }

}

function prev() {
    var date = $("#dateVal").text()


    let roomNo = parseInt($('#room').text());
    if (roomNo > 1) {
        $('#room').text(roomNo - 1);
        $('#roomNo').val(roomNo - 1);
        var room = parseInt($('#room').text());
        removeClass();
        reservedTimeCheck(date, room)
    }

}

function removeClass() {
    for (let j = 10; j <= 24; j++) {
        $('#' + (j)).removeClass();
    }
}

// 클릭된 시간 배열
const f1 = () => {
    let clickedClassList = document.getElementsByClassName("btn-success");
    console.log("클릭된 클래스 리스트는 : " + clickedClassList);
    let clickedTimeList = [];

    for (let i = 0; i < clickedClassList.length; i++) {
        var id = clickedClassList[i].getAttribute('id');
        clickedTimeList.push(id);
    }
    console.log(clickedTimeList.length);

    return clickedTimeList;
}


// 예약된 시간 배열(startTime 기준)
const f2 = () => {
    let reservedClassList = document.getElementsByClassName("btn-danger");
    let reservedTimeList = [];
    for (let i = 0; i < reservedClassList.length; i++) {
        var id = reservedClassList[i].getAttribute('id');
        reservedTimeList.push(id);

    }

    return reservedTimeList;
}

function clickTimetable(startTime) {
    let date = $('#dateVal').text();
    console.log(typeof(date))
    if (!date.trim()) {
        alert("일자를 먼저 선택해주십시오")
    } else {
        var timeClass = $('#' + (startTime)).attr('class');
        console.log(timeClass);


        if (timeClass == 'btn-danger') {
            alert("이미 예약된 시간입니다")
        } else if (timeClass == 'btn-success') {
            $('#' + (startTime)).removeClass();
        } else {
            $('#' + (startTime)).attr('class', 'btn-success')
            let clickedTimeArray = f1().sort();
            console.log(clickedTimeArray);
            for (let i = 0; i < clickedTimeArray.length; i++) {
                if ((clickedTimeArray[i + 1] - clickedTimeArray[i]) > 1) {
                    alert("연속된 시간만 예약 가능합니다.")
                    $('#' + (startTime)).removeClass();
                }
            }

        }

        let st = f1().sort()[0];
        let et = parseInt(f1().sort()[(f1().length - 1)]) + 1
        st += ":00";

        console.log("st는 : " + st);
        console.log("et는 : " + et);


        if (et === 24) {
            et = et - 1 + ":59";
            console.log(et);
        } else {
            et += ":00";
        }
        let sdt = date;
        sdt += (" " + st);

        let edt = date;
        edt += (" " + et);

        console.log("sdt : " + sdt);
        console.log("edt : " + edt);

        $('#startTime').val(sdt)
        $('#endTime').val(edt)
        if (f1().length === 0) {
            $('#startTime').val('');
            $('#endTime').val('');
        }
    }
}

//예약가능한 시간대 array
const f3 = () => {
    let timeArray = ['13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'];
    console.log(timeArray);
    let reservedTimeList = [];
    reservedTimeList = f2();
    console.log(reservedTimeList)

    for (let i = 0; i < timeArray.length; i++) {
        for (let j = 0; j < reservedTimeList.length; j++) {
            if (timeArray[i] === reservedTimeList[j]) {
                timeArray.splice(i, 1);
            }
        }
    }
    return timeArray;

}






