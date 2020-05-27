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
				  
                           <a href="/Project/main.cls" class="logo"><strong>Main page</strong></a>
                           <ul class="icons">
                              <li><a href="/Project/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </ul>
                      
				</header>

				<head>

<style type="text/css">
</style>

<script type="text/javascript">
        function writeForm(){
            location.href="/Project/board/boardW.jsp";
        }
    </script>

				</head>
				<body >

					<div id="wrap" >
						<br>
						<div id="topForm">
							<div class="w3-center ftt" >자유게시판</div>
							<c:if test="${sessionScope.sessionID!=null}">
							</c:if>
								<input type="button" value="글쓰기" onclick="writeForm()">
						</div>
						<br>
						<input class="tagbtn" type="button" value="전체">
						<input class="tagbtn"  type="button" value="공지">
						<input class="tagbtn"  type="button" value="팁">
						<input class="tagbtn"  type="button" value="이벤트">
						<div id="board">
							<table id="bList">
								<tr heigh="30">
									<td>종류</td>
									<td>글번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>조회수</td>
								</tr>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
								</tr>

							</table>
						</div>
						<br>
						<div id="pageForm">페이지 번호</div>
						<br>
						<div class="w3-center" id="searchForm" >
							<form>
								<select name="opt" style="margin: 10px;">
									<option value="0">제목</option>
									<option value="1">내용</option>
									<option value="2">제목+내용</option>
									<option value="3">글쓴이</option>
								</select> <input type="text" size="20" name="condition"
									style="margin: 10px;" />&nbsp; <input  type="submit"
									value="search" style="margin: 10px;" />
							</form>
						</div>
					</div>

				</body>



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
							   			<a href="/Project/main/main.jsp" width="0px;" height="0px;">
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

							<!-- Section -->
								<section>
									<header class="major">
									</header>
								</section>

							<!-- Section -->

						</div>
					</div>
	</div>

</body>
</html>