//데이트피커 설정
$.datepicker.setDefaults({
    dateFormat: 'yy년-mm월-dd일',
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