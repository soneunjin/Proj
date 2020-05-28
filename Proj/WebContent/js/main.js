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
			$(location).attr('href','/Project/main/main2.jsp');
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
		
		
	});