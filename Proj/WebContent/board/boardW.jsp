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
                              <li><a href="/Project/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </ul>
                       
				</header>

				<head>

<style type="text/css">
</style>

<script type="text/javascript">
        function writeForm(){
            location.href="BoardWriteForm.bo";
        }
    </script>

				</head>
				<br> <b><font size="6" color="gray">글쓰기</font></b> <br>

				<form method="post" action="BoardWriteAction.bo" name="boardForm"
					enctype="multipart/form-data">
					<input type="hidden" name="board_id"
						value="${sessionScope.sessionID}">
					<table width="700" border="3" bordercolor="lightgray"
						align="center">
						<tr>
							<td id="title">작성자</td>
							<td>${sessionScope.sessionID}</td>
						</tr>
						<tr>
							<td id="title">제 목</td>
							<td><input name="board_subject" type="text" size="70"
								maxlength="100" value="" /></td>
						</tr>
						<tr>
							<td id="title">내 용</td>
							<td><textarea name="board_content" cols="72" rows="20"></textarea>
							</td>
						</tr>
						<tr>
							<td id="title">파일첨부</td>
							<td><input type="file" name="board_file" /></td>
						</tr>

						<tr align="center" valign="middle">
							<td colspan="5"><input type="reset" value="작성취소"> <input
								type="submit" value="등록"> <input type="button"
								value="목록"></td>
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