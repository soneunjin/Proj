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
			$('#frm').submit();
			
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
		
		
	});