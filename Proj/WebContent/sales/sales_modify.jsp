<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
   Editorial by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<meta charset="utf-8" />
<title>게시글 작성</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/board.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/login.js"></script>
<script>
	$(document).ready(function(){
	   $('#save').click(function(){
		   var pno = $('#pno').val();
		   alert(pno);
	      //데이터 유효성 체크
	      $('#frm').submit();
	   });
	   
	   alert('${PNO}');
	   $('#list').click(function(){
		   $(location).attr('href', '/Project/sales/sales.cls');
	   });
   });
</script>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">

					<a href="index.jsp" class="logo"><strong>Main page</strong></a>
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

				<head>

<style type="text/css">
</style>
				</head>
				<br> <b><font size="6" color="gray">글수정</font></b> <br>

				<form method="post" action="/Project/sales/sales_modifyProc.cls" name="boardForm" id="frm">
					<input type="hidden" name="pno" id="pno" value="${PNO}">
					<table width="700" border="3" bordercolor="lightgray"
						align="center">
						<tr>
							<td>작성자</td>
							<td id="memid">${SID}</td>
						</tr>
						<tr>
							<td>분 류</td>
							<td>
							<div>
								<select name="cate">
									<option value="eat">음식점
									<option value="cth">자동차극장
									<option value="atc">캠핑장
									<option value="etc">기타
								</select>
							</div>
							</td>
						</tr>
						<tr>
							<td>제 목</td>
							<td><input id="ptt" name="ptt" type="text" size="50"
								maxlength="100" value="${PTT}"></td>
						</tr>
						<tr>
							<td >내 용</td>
							<td><textarea id="pbd" name="pbd" cols="72" rows="20">${PBD}</textarea>
							</td>
						</tr>
					</table>
						<div>
							<h3>파일첨부</h3>
							<hr>
							<input type="file" name="file"  style="margin: 5px;"><br>
							<input type="file" name="file" style="margin: 5px;" >
						</div>
				</form>
						<div style="position:relative; left: 40%;">
							<input type="button" id="save" value="등록">
							<input type="button" id="list" value="목록"></td>
						</div>

			</div>
		</div>
		<div id="sidebar">
			<div class="inner">
				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<a href="/Project/main.cls"><h2>MainPage</h2></a>
					</header>
					<ul>
						<li><a href="/Project/sales/sales.jsp">팝니당</a></li>
						<li><a href="/Project/review/review.cls">리뷰당</a></li>
						<li><span class="opener">가세용</span>
							<ul>
								<li><a href="#">D.T 점</a></li>
								<li><a href="#">자동차극장</a></li>
								<li><a href="#">자동차캠핑</a></li>
								<li><a href="#">선별진료소</a></li>
								<li><a href="#">주차장</a></li>
							</ul></li>
						<li><a href="#">놀러왕</a></li>
						<li><a href="#">물어봥</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>