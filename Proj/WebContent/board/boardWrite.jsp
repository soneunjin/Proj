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

				<br> <b><font size="6" color="gray">글쓰기</font></b> <br>

				<form id="frm" method="post"
					action="/Project/board/boardWriteProc.cls">
					<input type="hidden" name="board_id"
						value="${sessionScope.sessionID}">
					<table width="700" border="3" bordercolor="lightgray"
						align="center">
						<tr>
							<td>작성자 :</td>
							<td>${SID}</td>
						</tr>
						<tr>
							<td>제 목
							<td><select id="cate" style="width: 200px" name="cate">
							<c:if test="${SID eq 'sej0267@naver.com'}">
									<option value="공지">공지</option>
									</c:if>
									<option value="팁">팁</option>
									<option value="이벤트">이벤트</option>
									<input name="title" type="text" size="30" id="title">
							</select></td>
						</tr>
						<tr>
							<td>내 용</td>
							<td><textarea id="body" name="body" cols="72" rows="20"></textarea>
							</td>
						</tr>

						<tr align="center" valign="middle">
							<td colspan="5"><input type="reset" id="hbtn" value="작성취소">
								<input type="button" id="wbtn" value="등록"> <input
								type="button" id="bdh" value="목록"></td>
						</tr>
					</table>
				</form>
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