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
									<a href="/Project/main.cls" class="logo"><strong>Main page</strong></a>
									<ul class="icons">
									<c:if test="${empty SID}">
										<li class="btn w3-button" id="login"><b><span>SIGN IN</span></b></li>
									</c:if>
									<c:if test="${not empty SID}">
										<li id="mypage"><b><span>회원 정보</span></b></li>
										<a href="/Project/main/main3.jsp"><li class="btn" id="binfo"><b><span>사업자 정보</span></b></li></a>
										<li id="pwModi"><b><span>비밀번호 변경</span></b></li>
										<li id="logout"><b><span>SIGN OUT</span></b></li>
									</c:if>
									
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
										
									    <!-- 
    									<div id="menu_wrap" class="bg_white">
									    </div>
									     -->
										
										
										<!-- 
										<header>
											<h2> 내주변 위치 정보<br /></h2>
											<p></p>
										</header>
										<p>* 음식점 <br>
										   * 자동차 극장 <br>
										   * 자동차 캠핌장</p>
										 -->
										<!-- 
										<ul class="actions">
											<li><a href="#" class="button big">Learn More</a></li>
										 -->
					
									
									<FORM method="post" action="/Project/member/EditInfo.cls" id="frm" name="frm">
									<span class="image object">
										<div class="cont">
										  <div class="form sign-in">
										    <h2>내 정보 수정</h2>
										    <label>
										      <span for="id">이메일</span>
										      <input id="memid" name="memid" type="text" value="${DATA.memid}" readonly>
										    </label>
										    <label>
										      <span for="name">이름</span>
										      <input type="text" value="${DATA.name}" readonly>
										    </label>
										    <label>
										      <span for="phone">핸드폰번호</span>
										      <input  id="phone" name="phone" type="text" placeholder="${DATA.phone}">
										    </label>
										    <label>
										      <span for="membir">생년월일 : </span>
										      <input type="text" value="${DATA.membir}" readonly>
										    </label>
										    <label>
										      	<select name="opt" style="margin: 0px;">
	                           					   <option value="1" id="ab1">소형</option>
						                           <option value="2" id="ab2">경형</option>
						                           <option value="3" id="ab3">준중형</option>
						                           <option value="4" id="ab4" >중형</option>
						                           <option value="5" id="ab5">준대형</option>
						                           <option value="6" id="ab6">대형</option>
						                           <option value="7" id="ab7">스포츠카</option>
						                           <option value="8" id="ab8">기타</option>
					                        	</select>
										    </label>
										
										    <button type="button" class="submit" id="lbtn">Submit</button>
										  </div>
										  </div>   
									</span>
									</FORM>


										<!-- <img src="images/pic10.jpg" alt="" /> -->
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
							   			<a href="/Project/main.cls">
							   			<img class="ima_1" src="/Project/images/main.png" border="0" />
							   			</a>
										<h2>Manu</h2>
									</header>
									<ul>
										<li><a href="/Project/main.cls">모른당X</a></li>
										<li><a href="/Project/sales/sales.jsp">팝니당$</a></li>
										<li>
											<span class="opener">오세용~</span>
											<ul>
												<li><a href="#">음식점</a></li>
												<li><a href="#">자동차 극장</a></li>
												<li><a href="#">자동차 캠핌장</a></li>
												<li><a href="#">주차장 정보</a></li>
												<li><a href="#"></a></li>
											</ul>
										</li>
										<li><a href="/Project/qna/qnaList.jsp">놀러왕!</a></li>
										<li><a href="/Project/board/board.jsp">물어봥?</a></li>
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