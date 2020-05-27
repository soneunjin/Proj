<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>드라이브 스루</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/Project/assets/css/main.css" />
		<link rel="stylesheet" href="/Project/css/w3.css" />
		<link rel="stylesheet" href="/Project/css/map1.css" />
		<link rel="stylesheet" href="/Project/css/login1.css">
		<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
		<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
	</head>
	<script type="text/javascript">
	$(function(){
		/*
		$('#login').click(function(){
			$(location).attr('href', '/Project/member/login.cls');
		});
		
		$('#logout').click(function(){
			$(location).attr('href', '/clsProj/member/logoutProc.cls');
		});
		*/
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
		
	});
</script>
	<body class="is-preload" >
		

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<div class="inner">
							

							<!-- Header -->
								<header id="header">
									<a href="/Project/main/main.cls" class="logo"><strong>Main page</strong></a>
									<ul class="icons">
									<c:if test="${empty SID}">
										<li class="btn w3-button" id="login"><b><span>SIGN IN</span></b></li>
									</c:if>
									<c:if test="${not empty SID}">
										<li class="btn" id="mypage"><b><span>회원 정보</span></b></li>
										<li class="btn" id="binfo"><b><span>사업자 정보</span></b></li>
										<li class="btn" id="pwModi"><b><span>비밀번호 변경</span></b></li>
										<li class="btn" id="logout"><b><span>SIGN OUT</span></b></li>
									</c:if>
									
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
								  <!--  이섹션 밑에다가 넣어주면되 -->
									


								</section>





							<!-- Section -->
								<!-- 
								<section>
									<header class="major">
									</header>
								</section>
								 -->

							<!-- Section -->

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">
							<!-- 
							<!-- Main link -->
	
							<!-- Menu -->
								<nav id="menu">
									<header class="major">
							   			<a href="/Project/main/main.jsp">
							   			<img class="ima_1" src="/Project/images/main.png" border="0" />
							   			</a>
										<h2>Manu</h2>
									</header>
									<ul>
										<li><a href="/Project/sales/sales.cls">팝니당$</a></li>
										<li>
											<span class="opener">오세용~</span>
											<ul>
												<li><a href="#">자동차 극장</a></li>
												<li><a href="#">자동차 캠핌장</a></li>
												<li><a href="#">승차 검진소</a></li>
												<li><a href="#"></a></li>
											</ul>
										</li>
										<li><a href="/Project/board/board.cls">놀러왕!</a></li>
										<li><a href="/Project/qna/qnaList.cls">물어봥?</a></li>
										<li><a href="/Project/review/review.cls">리뷰당?</a></li>
										<!--
										<li>
											 <span class="opener">Another Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Maximus Erat</a></li>
										<li><a href="#">Sapien Mauris</a></li>
										<li><a href="#">Amet Lacinia</a></li>
									</ul> -->
									</ul>
								</nav>


						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="/Project/assets/js/jquery.min.js"></script>
			<script src="/Project/assets/js/browser.min.js"></script>
			<script src="/Project/assets/js/breakpoints.min.js"></script>
			<script src="/Project/assets/js/util.js"></script>
			<script src="/Project/assets/js/main.js"></script>
			
<script>
</script>
	</body>
</html>