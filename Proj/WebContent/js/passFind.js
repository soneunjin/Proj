	$(document).ready(function () {
		
		// 아이디 찾기 버튼
		$('#sbtn').click(function () {
			 // 1. 데이터 읽고
	         var sid = $('#name').val();
	         var spw = $('#email').val();
	         // 2. 유효성 검사하고
	         if(!sid){
	            $('#name').focus();
	            alert('올바른 이름이 아닙니다.')
	            return;
	         }
	         if(!spw){
	            $('#email').focus();
	            alert('올바른 아이디가 아닙니다.')
	            return;
	         }
			$('#frm').submit();
		});
		
		// 취소버튼
		$('#cbtn').click(function() {
			$(location).attr('href','/Project/member/login.cls');
		});
});