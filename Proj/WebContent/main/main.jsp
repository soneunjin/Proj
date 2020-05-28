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
		<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
		<script type="text/javascript" src="/Project/js/main.js"></script>
		<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
	</head>
<script type="text/javascript">
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
										<li id="binfo"><b><span>사업자 정보</span></b></li></a>
										<li id="pwModi"><b><span>비밀번호 변경</span></b></li>
										<li class="btn" id="logout"><b><span>SIGN OUT</span></b></li>
									</c:if>
									
									</ul>
								</header>

							<!-- Banner -->
							<section id="banner">
									<div class="" style="overflow:scroll; width:330px; height: 620px; padding:0px;">
										<header>
											<h2><b> TOP 10 추천</b></h2><br>
											<p></p>
										</header>
										<p class="list">
											<c:forEach var="data" items="${LIST}">
											   <span class="loc" style="font-size: 15pt;"><span id="${data.bloc}">${data.bname}</span></span>
											   <span style="color: orange;">별점: ★${data.rd}</span><br><br>
											</c:forEach>
										</p>
										<!-- 
										 -->
									</div>
										<!--
										<ul class="actions">
											<li><a href="#" class="button big">Learn More</a></li>
										 
										 -->
									<div class="image object" >
										<div id="map2" style="width: 700px;height:600px; margin-left: -50px;"></div>
									</div>	
								
									</section>
										<!-- <img src="images/pic10.jpg" alt="" /> -->

							<!-- Section -->
								<!-- 
								<section>
									<header class="major" style="margin-top: -20px;">
									
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
							   			<img class="ima_1" src="/Project/images/main.png" border="0" />
										<h2>Menu</h2>
									</header>
									<ul>
										<li>
											<span class="opener">오세용</span>
											<ul>
												<li><a href="/Project/info/infoCT.cls">자동차 극장</a></li>
												<li><a href="/Project/info/infoCP.cls">자동차 캠핌장</a></li>
												<li><a href="/Project/info/infoDTC.cls">승차 검진소</a></li>
											</ul>
										</li>
										<li><a href="/Project/sales/sales.cls">팝니당</a></li>
										<li><a href="/Project/review/review.cls">리뷰당?</a></li>
										<li><a href="/Project/board/board.cls">놀러왕!</a></li>
										<li><a href="/Project/qna/qnaList.cls">물어봥?</a></li>
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
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
			<script type="text/javascript">
			$(function(){
				var mapContainer = document.getElementById('map2');
				var mapOption = {
				    center: new kakao.maps.LatLng(37.4821113, 126.8992314), // 지도의 중심좌표
				    level: 3 // 지도의 확대 레벨
				}// 지도를 표시할 div 
				
				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 
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
				
				$('.loc').click(function(){
					var loc = $(this).children().attr('id');
					var name = $(this).children().html();
						
				
				
					
					// 지도 전체 코드
					var mapContainer = document.getElementById('map2');
					var mapOption = {
					    center: new kakao.maps.LatLng(37.517274, 126.981174), // 지도의 중심좌표
					    level: 3 // 지도의 확대 레벨
					}// 지도를 표시할 div 
					
					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 
					
					
					// 주소-좌표 변환 객체를 생성합니다
					var geocoder = new kakao.maps.services.Geocoder();
					// 서울시 구로구 시흥대로 163길 21
					 
					// 주소로 좌표를 검색합니다
					geocoder.addressSearch(loc, function(result, status) {
					
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
					
					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					        
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });
					
					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
					        });
					        infowindow.open(map, marker);
					
					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        
					        map.setCenter(coords);
					     }
					});   
					
					// 지도 전체 코드
				});
			});		
		
					
			// 전체함수 감싸는 놈 (위에 기능)	
		</script>
	</body>
</html>