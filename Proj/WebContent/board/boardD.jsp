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

					<a href="index.jsp" class="logo"><strong>Main page</strong></a>
					<ul class="icons">
						<li><a href="/Project/login.jsp" class="w3-col"><b><span>SIGN
										IN</span></b></a></li>
					</ul>

				</header>

				<head>

<style type="text/css">
</style>

<script type="text/javascript">
	function writeForm() {
		location.href = "BoardWriteForm.bo";
	}
</script>

				</head>
				<div id="wrap">
					<br> <br>
					<div id="board">
						<table id="detailBoard" width="50%" border="3" bordercolor="black">


							<tr>
								<td class="title">제 목</td>

							</tr>
							<tr>
								<td>${board.board_subject}제목</td>
							</tr>
							<tr>
								<td class="title">내 용</td>
							</tr>
							<tr>
								<td>${board.board_content}내용입력란입니다.</td>
							</tr>
							<tr>
						</table>
						<table>
							<td class="title">작성일</td>
							<td>${board.board_date}date</td>
							<td class="title">작성자</td>
							<td>${board.board_id}작성자</td>
							<td class="title">조회수</td>
							<td>${board.board_content}999</td>
						</tr>
						</table>
						<table>

							<tr align="center" valign="middle">
								<td colspan="5"><input type="button" value="수정"> <input
									type="button" value="삭제"> <input type="button" value=답글>
									<input type="button" value="목록"
									onclick="javascript:location.href='BoardListAction.bo?page=${pageNum}'">
								</td>
							</tr>
						</table>
					</div>
				</div>
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