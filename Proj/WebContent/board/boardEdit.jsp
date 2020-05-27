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
<title>메인페이지</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/board.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/board.js"></script>

<script type="text/javascript" src="/Project/js/login.js"></script>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="/Project/main/main.jsp" class="logo"><strong>Main
							page</strong></a>
					<ul class="icons">
						<c:if test="${empty SID}">
							<li class="btn w3-button" id="login"><b><span>SIGN
										IN</span></b></a></li>
						</c:if>
						<c:if test="${not empty SID}">
							<li class="btn w3-col" id="logout"><b><span>SIGN
										OUT</span></b></a></li>
						</c:if>

					</ul>
				</header>
				
				<br> <b><font size="6" color="gray">수정하기</font></b> <br>
				<form method="post" action="" id="efrm">
					
				</form>
				<form id="frm" method="post"
					action="/Project/board/boardEditProc.cls">
					<input type="hidden" name="board_id"
						value="${sessionScope.sessionID}">
					<input type="hidden" name="no" id=no value="${bdno}">
					<table width="700" border="3" bordercolor="lightgray"
						align="center">
						<tr>
							<td>작성자 :</td>
							<td>${SID}</td>
						</tr>
						<tr>
							<td>제 목
							<td><select id="cate" style="width: 100px" name="cate">
									<option value="공지">공지</option>
									<option value="팁">팁</option>
									<option value="이벤트">이벤트</option>
							</select> <input name="title" type="text" size="30" id="title"
								value="${DATA.bdtt}"></td>
						</tr>
						<tr>
							<td>내 용</td>
							<td><textarea id="body" name="body" cols="72" rows="20">${DATA.bdbd}</textarea>
							</td>
						</tr>

						<tr align="center" valign="middle">
							<td colspan="5"><input type="reset" id="hbtn" value="작성취소">
								<input type="button" id="editbtn" value="수정"> <input
								type="button" value="목록"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>



		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->


				<!-- Menu -->
				<nav id="menu">
					<header class="major w3-padding-top">
						<img class="dtlogo" src="../images/logo.png" width="300px"
							height="auto"> <a href="main.jsp"><h2>menu</h2></a>
					</header>
					<ul>
						<li><a href="index.html">모른당X</a></li>
						<li><a href="elements.html">팝니당$</a></li>
						<li><span class="opener">오세용~</span>
							<ul>
								<li><a href="#">자동차극장</a></li>
								<li><a href="#">자동차캠핑</a></li>
								<li><a href="#">선별진료소</a></li>
							</ul></li>
						<li><a href="#">놀러왕!</a></li>
						<li><a href="#">물어봥?</a></li>

					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>