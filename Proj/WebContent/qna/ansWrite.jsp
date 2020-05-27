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
                           <c:if test="${empty SID}">
                              <li><a href="/Project/member/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </c:if>
                              <li><a href="/Project/member/logoutProc.cls" class="w3-col"><b><span>SIGN OUT</span></b></a></li>
                           </ul>
				</header>

				<head>

<style type="text/css">
</style>

<script type="text/javascript">
        $(function(){
        	$('#golbtn').click(function(){
        		$(location).attr('href','/Project/qna/qnaList.cls');
        	});
        	
        	$('#wcbtn').click(function(){
        		$(location).attr('href','/Project/qna/qnaList.cls');
        	});
        	
        	$('.dtlogo').click(function(){
        		$(location).attr('href','/Project/main.cls');
        	});
        	
        	$('#sbbtn').click(function(){
        		alert('글등록');
        		var qtt = document.getElementById('qtt2').value;
        		var qip = document.getElementById('qip2').value;
        		alert(qtt);
        		alert(qip);
        		$('#qtt').val(qtt);
        		$('#qbd').val(qip);
        		$('#qnaWForm').attr('action', '/Project/qna/qnaProc.cls');
        		$('#qnaWForm').submit();
        	});
        	
        	$('#modibtn').click(function(){
        		alert('눌렸습니다');
        		var qtt = document.getElementById('qtt1').value;
        		var qip = document.getElementById('qip1').value;
        		$('#qqtt').val(qtt);
        		$('#qqbd').val(qip);
        		$('#qnaForm').attr('action', '/Project/qna/qnaModiProc.cls');
        		$('#qnaForm').submit();
        	});
        });
    </script>
	
				</head>
				<br> <b><font size="6" color="gray">글쓰기</font></b> <br>

				<form method="post" action="" name="qnaForm" id="qnaForm">
					<input type="hidden" id="sid" name="id" value="${SID}">
					<input type="hidden" id="qqno" name="qqno" value="${qno}">
					<input type="hidden" id="qqtt" name="qqtt">
					<input type="hidden" id="qqbd" name="qqbd">
				</form>
				<form method="post" action="" name="qnaWForm" id="qnaWForm">
					<input type="hidden" id="sid" name="id" value="${SID}">
					<input type="hidden" id="qno" name="qno" value="${qno}">
					<input type="hidden" id="qtt" name="qtt">
					<input type="hidden" id="qbd" name="qbd">
				</form>
					<table width="700" border="3" bordercolor="lightgray" align="center">
						
						<tr>
							<td id="title">작성자</td>
							<td>${ANSWER.name}</td>
						</tr>
						<tr>
							<td id="title">제 목</td>
						
							<td>
								<input name="qtt" type="text" size="70"maxlength="100" id="qtt1" value="${ANSWER.qtt}"/>
							</td>
						</tr>
						<tr>
							<td id="title">내 용</td>
						
							<td>
								<textarea name="qip" cols="72" rows="20" id="qip1" placeholder="">${ANSWER.qip}</textarea>
							</td>
						</tr>

						<tr align="center" valign="middle">
						<!-- 글 수정 작업시 아래 -->
							<td colspan="5">
								<input type="reset" value="작성취소" id="wcbtn"> 
								<input type="submit" value="글수정" id="modibtn"> 
								<input type="button" value="목록" id="golbtn">
							</td>
						
						</tr>
					</table>
			</div>
		</div>
		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->


				<!-- Menu -->
				<nav id="menu">
					<header class="major w3-padding-top">
						<img class="dtlogo" src="/Project/images/main.png" width="300px"
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