$(function(){
		
		$('.btn').click(function() {
			var tid = $(this).attr('id');
			var url = '';
			if(tid == 'login') {
				url = '/Project/member/login.cls';
			} else if (tid == 'logout') {
				url = '/Project/member/logoutProc.cls';
			
			}
			
			$(location).attr('href', url);
		});
		
		
		$('#pobtn').click(function() {
			if (!isPhone(phone)) {
   	    	 	alert('핸드폰 번호를 다시입력해주세요. ex) 01012345678');
     			$('#Phone').focus();
     			return;
			}
		$('#frm1').submit();
		alert('회원정보가 성공적으로 변경되었습니다.');
		});

		$('#lbtn').click(function() {
			var spwa = $('#pw').val();
			var spw = $('#pwe').val();
			var gpw = $('#gpw').val();
			var cnt = $('#abc').val();
			alert(cnt);
			 if (!isPw(spwa)) {
    	    	alert('비밀번호 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내');
    	    	$('#pw').focus();
    	    	return;
    	     } else if(spwa != spw) {
    	    	alert('새비밀번호와 새비밀번호확인이 다릅니다.');
    	    	$('#pwe').focus();
    	    	return false;
    	     } 
			$('#frm').submit();
			alert('성공적으로 변경되었습니다.');
		});
		
		
		$('#mypage').click(function () {
			$(location).attr('href','/Project/member/InFoProc.cls');
			alert('회원정보 페이지로!!!');
		});
		
		$('#pwModi').click(function() {
			$(location).attr('href','/Project/member/main2.cls');
			alert('비밀번호 변경 페이지로!!!')
		});
		
		$('#binfo').click(function () {
			$(location).attr('href','/Project/main/InsertCo.cls');
			alert('사업자 등록 페이지로!!!')
		});
		
		$('.ima_1').click(function() {
			$(location).attr('href','/Project/main.cls');
			alert('메인 홈페이지로!!');
		});
		
		// 비밀번호 정규식
	   	   function isPw(pw) {
		   
	   		var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[*!@#$%^&+=]).*$/;
	   		
	   		return regex.test(pw);
	   }
	   	 
	   	// 핸드폰번호 정규식
	   	function isPhone(ph) {
	 	   var phone = /(^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})$/;
	 	   
	 	   return phone.test(ph);
	    }	   
		
		
	});