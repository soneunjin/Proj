<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Detail Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<link rel="stylesheet" href="../assets/css/sales.css" />
<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
</head>
<body class="is-preload">
	<script type="text/javascript" src="/Project/assets/js/sales.js"></script>
	<script type="text/javascript">
		alert('${IMG}');
		$(document).ready(function(){
			$('.btn').click(function() {
				var tid = $(this).attr('id');
				var url = '';
				if(tid == 'login') {
					url = '/Project/member/login.cls';
				} else if (tid == 'logout') {
					url = '/Project/member/logoutProc.cls';
				}
			   });
			   $('#list').click(function(){
				   $(location).attr('href', '/Project/sales/sales.cls');
			   });
			   
			   $('#review').click(function(){
				   var pno = $('#pno').val();
				   $('#frm1').attr('action', '/Project/review/review_write.cls');
				   $('#frm1').submit();
			   });
			   $('#delete').click(function(){
				   var pno = $('#pno').val();
				   $('#frm1').attr('action', '/Project/sales/sales_delete.cls');
				   $('#frm1').submit();
			   });
			   $('#modi').click(function(){
				   var pno = $('#pno').val();
				   $('#frm1').attr('action', '/Project/sales/sales_modify.cls');
				   $('#frm1').submit();
			   });
			   $('.gohome').click(function(){
				  $(location).attr('href','/Project/main.cls'); 
			   });
			   
		   }); 
	</script>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="/Project/main.cls" class="logo"><strong>Sales page</strong></a>

					<div class="icons">
                 	<a href="/Project/login.cls" class="">
	                  	<c:if test="${empty SID}">
							<div class="btn w3-button" id="login"><b><span>SIGN IN</span></b></a></div>
						</c:if>
					<c:if test="${not empty SID}">
						<div class="btn w3-col" id="logout"><b><span>SIGN OUT</span></b></a></div>
					</c:if>
               </div>
				</header>
               	 <form method="post" action="/Project/sales/sales.cls" id="frm">
					<input type="hidden" name="ptt"  value="${DATA.ptt}">
					<input type="hidden" name="pbd"  value="${DATA.pbd}">
					<input type="hidden" name="cate"  value="${DATA.cate}">
					<input type="hidden" name="rno"  value="${DATA.rno}">
					<input type="hidden" name="rtt"  value="${DATA.rtt}">
					<input type="hidden" name="rbd"  value="${DATA.rbd}">
					<input type="hidden" name="memno"  value="${DATA.memno}">
					<input type="hidden" name="rst"  value="${DATA.rst}">
					<input type="hidden" name="today"  value="${DATA.today}">
				</form>
               	<form method="post" action="" id="frm1">
					<input type="hidden" name="pno" id="pno" value="${PNO}">
					<input type="hidden" name="ptt"  value="${DATA.ptt}">
					<input type="hidden" name="pbd"  value="${DATA.pbd}">
               	 </form>
               	<form method="post" action="" id="frm2">
					<input type="hidden" name="pno" id="pno" value="${PNO}">
					<input type="hidden" name="ptt"  value="${DATA.ptt}">
					<input type="hidden" name="pbd"  value="${DATA.pbd}">
					<input type="hidden" name="cate"  value="${DATA.cate}">
               	 </form>
				<div id="wrap">
					<br>
					<div id="topForm" style="text-align: left; padding-left: 10px;"><b>매장 정보</b></div>
					<hr style="margin: 15px;">
					<br>
					<div id="board" style="width: 1000px;">
					<c:if test="${not empty CAR}">
						<div style="text-align: left;">
							<h5 style="font-color: gray; padding-left: 15px;" name="car">매장진입 추천차량</h5>
							<h4 style="padding-left: 20px;;"><b>${CAR}</b></h4>
						</div>
					</c:if>
							<h2 style="margin:7px; display:inline" name="ptt"><b>${DATA.ptt}</b></h2>
							<h4 style="margin:7px; margin-left: 15px;" name="bceo">${DATA.bceo}</h4>
							<h4 style="font-color: gray; padding-left: 15px;" name="bloc">${DATA.bloc}</h4>
					</div>
					<br>
					 <br>
					 <div id="map" style="width:450px;height:450px; display: inline-block; margin-left: 50px;"></div>
					 <span style="margin: 20px;">
					 <img alt="" src="/Project/images/${IMG}" style="height:450px; width:450px;">
					</span>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bfbcb2a9b1a94611a8804b0d71d6315c&libraries=services"></script>
					<script>
					var mapContainer = document.getElementById('map');
					var mapOption = {
					    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					    level: 3 // 지도의 확대 레벨
					}// 지도를 표시할 div 
					
					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 
					
					
					// 주소-좌표 변환 객체를 생성합니다
					var geocoder = new kakao.maps.services.Geocoder();
					 
					// 주소로 좌표를 검색합니다
					geocoder.addressSearch('${DATA.bloc}' , function(result, status) {
					
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
					            content: '<div style="width:150px;text-align:center;padding:6px 0;">${DATA.ptt}</div>'
					        });
					        infowindow.open(map, marker);
					
					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        
					        map.setCenter(coords);
					     }
					});   
					</script>
					<br>
			
			</div>
			<hr style="border:1px solid orange">
					 <div name="pbd" id="pbd">
					 	<h3 style="text-align: center; margin: 40px;">${DATA.pbd}</h3>
					 </div>
			<div style="position:relative; left: 40%;">
 			<c:if test="${SID eq ID}">
				<input type="button" id="delete" value="삭제">
				<input type="button" id="modi" value="수정">				
			</c:if>
				<input type="button" id="list" value="목록">
				<input type="button" id="review" value="리뷰쓰기">
			</div>
			<br>					
				</div>
		</div>
		<!-- Sidebar -->
		<div id="sidebar" style="width: 350px;">
			<div class="inner" style="width: 350px;">
				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<img class="ima_1 gohome" src="/Project/images/main.png" border="0" />
						<a href=""><h2>Menu</h2></a>
					</header>
				<ul>
					<li>
						<span class="opener">오세용</span>
						<ul>
							<li><a href="/Project/info/infoCT.cls">자동차 극장</a></li>
							<li><a href="/Project/info/infoCP.cls">자동차 캠핌장</a></li>
							<li><a href="/Project/info/infoDTC.cls">진료소 정보</a></li>
						</ul>
					</li>
					<li><a href="/Project/sales/sales.cls">팝니당</a></li>
					<li><a href="/Project/review/review.cls">리뷰당</a></li>
					<li><a href="/Project/board/board.cls">놀러왕</a></li>
					<li><a href="/Project/qna/qnaList.cls">물어봥</a></li>
               </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>