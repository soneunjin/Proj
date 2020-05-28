<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<meta charset="utf-8" />
		<title>드라이브 스루</title>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/Project/assets/css/main.css" />
		<link rel="stylesheet" href="/Project/css/w3.css" />
		<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
		
	</head>
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
										<li class="btn w3-button" id="login"><b><span>SIGN IN</span></b></a></li>
									</c:if>
									<c:if test="${not empty SID}">
										<li class="btn w3-col" id="logout"><b><span>SIGN OUT</span></b></a></li>
									</c:if>
									
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="" style="overflow:scroll; width:300px; height: 500px; padding:0px;">
										<header>
											<h3><b> 오토캠핑장 위치 정보</b></h3><br>
											<p></p>
										</header>
										<p class="list">
											<c:forEach var="data" items="${INFO}">
											   <div class="content"><h4 id="${data.ifaddr}">${data.ifname}</h4><br></div>
											</c:forEach>
										</p>
										<!-- 
										 -->
									</div>
										<!--
										<ul class="actions">
											<li><a href="#" class="button big">Learn More</a></li>
										 
										 -->
									<div class="image object" style="width: 500px; margin-right: 20px;" >
										<div id="map1" style="width: 500px;height:500px; margin-left: -50px;"></div>
										<div id="map2" style="width: 500px;height:500px; margin-left: -50px;"></div>
									</div>	 
									<div class="detail" style="margin-left: -50px;">
									  <!--  <img class="w3-border" style="width: 350px; height: 350px; float: left; margin-right: 15px;" id="img1" src="../images/acp_photo.jpg" alt="Image"> -->
											<span style="font-size: 20px;"><b> 캠핑장 이름 : </b></span> <span style="font-size: 20px;" id="ctname"></span><br><br>
											<span style="font-size: 20px;"><b> 연락처 : </b></span> <span style="font-size: 20px;" id="cttel"></span><br><br>
											<span style="font-size: 20px;"><b> 주소 : </b></span> <span style="font-size: 20px;" id="ctaddr"></span><br><br>
											<span style="font-size: 20px;"><b> 이용가격 : </b></span> <span style="font-size: 20px;" id="ctpri"></span><br><br>
											<span style="font-size: 20px;"><b> 홈페이지 : </b></span> <a id="hplink" href="" target="_blank"><span style="font-size: 20px;" id="ctlink">링크</span></a><br><br>
											<span style="font-size: 20px;"><b> 길찾기 바로가기 : </b></span> <a id="search" href="" target="_blank"><span style="font-size: 20px;" id="ctlink">링크</span></a><br><br>
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
							   				<img class="ima_1" src="../images/main.png" border="0" />
							   			</a>
										<h2>Menu</h2>
									</header>
									<ul>
									<li><span class="opener">오세용</span>
										<ul>
											<li><a href="/Project/info/infoCT.cls">자동차극장</a></li>
											<li><a href="/Project/info/infoCP.cls">자동차캠핑</a></li>
											<li><a href="/Project/info/infoDTC.cls">승차검진소</a></li>
										</ul>
									</li>
									<li><a href="/Project/sales/sales.cls">팝니당</a></li>
									<li><a href="/Project/review/review.cls">리뷰당</a></li>
									<li><a href="/Project/board/board.cls">놀러왕</a></li>
									<li><a href="/Project/qna/qnaList.cls">물어봥</a></li>
									</ul>
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
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
									</header>
								</section>

							<!-- Section -->

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
				$('.detail').css('display', 'none');
				/*
				$('#login').click(function(){
					$(location).attr('href', '/Project/member/login.cls');
				});
				
				$('#logout').click(function(){
					$(location).attr('href', '/clsProj/member/logoutProc.cls');
				});
				*/
				var ii;
				$('#map2').css('display','none');
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
				
				$('.content').hover(function(){
	        		$(this).css('color','brown');
	        	},function(){
	        		$(this).css('color','gray');
	        	});
				
				$('.list').siblings().click(function(){
					$('#map2').css('display', '');
					$('#map1').css('display', 'none');
					var name = $(this).children().html();
					var ii = $(this).children().attr('id');
					
					$.ajax({
						url: "/Project/ajax/infoDetail.ck",
						type: 'POST',
						dataType: 'json',
						data:{
							"name":name
						},
						success: function(obj){
							$('.detail').css('display', '');
							var name = obj.name;
							var tel = obj.tel;
							var addr = obj.addr;
							var price = obj.price;
							var link = obj.link;
							$('#ctname').html(name);
							$('#cttel').html(tel);
							$('#ctaddr').html(addr);
							$('#ctpri').html(price);
							$('#hplink').attr('href', link);
							$('#search').attr('href','https://map.kakao.com/link/search/' + addr);
						},
						error: function(){
							alert('통신에러!!!');
						}
			});  
					
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
					geocoder.addressSearch( ii , function(result, status) {
					
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
			
			
			
				// 지도 전체 코드
					var mapContainer = document.getElementById('map1');
					var mapOption = {
					    center: new kakao.maps.LatLng(37.517274, 126.981174), // 지도의 중심좌표
					    level: 7 // 지도의 확대 레벨
					}// 지도를 표시할 div 
					
					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 
					
					
				
					
					// 지도 전체 코드
					
			// 전체함수 감싸는 놈 (위에 기능)	
			});		
			</script>

	</body>
</html>