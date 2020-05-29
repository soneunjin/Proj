
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
<title>자유게시판</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/board.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/board.js"></script>
<script type="text/javascript" src="/Project/js/login.js"></script>
<script type="text/javascript">
/* 	window.addEventListener("keydown", function(event) {
		if (event.defaultPrevented) {
			return;
		}
		var handled = false;
		if (event.keyCode == 116)
			handled = true;

		if (handled) {
			console.log(event.keyCode);

			event.preventDefault();
		}
	}, true); */
</script>
</head>
<body class="is-preload">

	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">


				<!-- Header -->
				<header id="header">
					<a href="/Project/main.cls" class="logo"><strong>Main
							page</strong></a>
					<ul class="icons">
						<c:if test="${empty SID}">
							<li class="btn w3-button" id="login"><b><span>SIGN
										IN</span></b></li>
						</c:if>
						<c:if test="${not empty SID}">
							<li class="btn" id="logout"><b><span>SIGN OUT</span></b></li>
						</c:if>

					</ul>
				</header>

				<head>

<form method="post" action="" id="dtfrm">
	<input type="hidden" name="no" id=no value="${bdno}"> <input
		type="hidden" name="tt" id="tt" value="${DATA.bdtt}"> <input
		type="hidden" name="bd" id="bd" value="${DATA.bdbd}">
</form>
<form method="post" action="" id="dtbno">
	<input type="hidden" name="no" id="no" value="${bdno}">
</form>
				</head>
				<div id="content">
					<br> <br>
					<div id="board">
						<table id="detailBoard" width="50%" border="3" bordercolor="black">

							<tr>
								<td class="title">작성일</td>
								<td>${DATA.sdate}</td>
								<td class="title">작성자</td>
								<td>${DATA.name}</td>
								<td class="title">조회수</td>
								<td>${DATA.vcnt+1}</td>
							</tr>
						</table>
						<table>
							<tr>
								<td class="title w3-border w3-card">제 목</td>
							</tr>
							<tr>
								<td>${DATA.bdtt}</td>
							</tr>
							<tr>
								<td class="title w3-border w3-card">내 용</td>
							</tr>
							<tr>
								<td>${DATA.bdbd}</td>
							</tr>
						</table>


						<tr align="center" valign="middle">
							<td colspan="5"><c:if test="${SID eq DATA.memid}">
									<input class="editdetail" type="button" value="수정">
									<input class="deletedetail" type="button" value="삭제">
								</c:if> <input class="comment" type="button" value=답글
								onclick="showPopup();"> <input type="button" value="목록"
								onclick="javascript:location.href='/Project/board/board.cls'">
							</td>
						</tr>
						</table>

						<table class="w3-margin-top">
							<thred>
							<tr heigh="30">
								<td>작성자</td>
								<td>내용</td>
								<td>작성일</td>

							</tr>
							</thred>
							<form method="post" action="" id="frmdt">
								<input type="hidden" name="bno" id="bno" value="${list.bdno}">

								<c:forEach var="list" items="${LIST}">
									<tr class="w3-text-gray comendetail" id="${list.bdno}">
										<td>${list.name}</td>
										<input type="hidden" name="bd" id="bd" value="${list.bdbd}">
										<td>${list.bdbd}</td>
										<td>${list.sdate}</td>
									</tr>
								</c:forEach>
							</form>
						</table>

						<!-- 
						<c:forEach var="data" items="${LIST}">
						
						</c:forEach>
 -->
					</div>

				</div>
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
						<a href="/Project/main.cls" width="0px;" height="0px;"> <img
							class="ima_1" src="/Project/images/main.png" border="0" />
							<h2>Menu</h2>
					</header>
					<ul>
						<li><a class="opener" href="/Project/info/infoCT.cls">오세용</a>

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
</body>
</html>