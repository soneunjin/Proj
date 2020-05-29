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
<title>Q&A</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/board.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/login.js"></script>
</head>

<style type="text/css">
</style>

<script type="text/javascript">
        $(function(){
        	$('.logo').click(function(){
        		$(location).attr('href','/Project/qna/qnaList.cls');
        	});
        	
        	$('.opener').click(function(){
        		$(location).attr('href','/Project/info/infoCT.cls');
        	});
        	
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
        		var qtt = document.getElementById('qtt2').value;
        		var qip = document.getElementById('qip2').value;
        		$('#qtt').val(qtt);
        		$('#qbd').val(qip);
        		$('#qnaWForm').attr('action', '/Project/qna/qnaProc.cls');
        		$('#qnaWForm').submit();
        	});
        	
        	$('#modibtn').click(function(){
        		var qtt = document.getElementById('qtt4').value;
        		var qip = document.getElementById('qip4').value;
        		$('#qqtt').val(qtt);
        		$('#qqbd').val(qip);
        		$('#qnaForm').attr('action', '/Project/qna/qnaModiProc.cls');
        		$('#qnaForm').submit();
        	});
        	$('#ansmodibtn').click(function(){
        		var qtt = document.getElementById('qtt3').value;
        		var qip = document.getElementById('qip3').value;
        		$('#qqtt').val(qtt);
        		$('#qqbd').val(qip);
        		$('#qnaForm').attr('action', '/Project/qna/qnaModiProc.cls');
        		$('#qnaForm').submit();
        	});
        });
    </script>
	
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
	
                           <a class="logo"><strong>Q&A page</strong></a>
                           <ul class="icons">
                           <c:if test="${empty SID}">
                              <li><a href="/Project/member/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </c:if>
                              <li><a href="/Project/member/logoutProc.cls" class="w3-col"><b><span>SIGN OUT</span></b></a></li>
                           </ul>
				</header>

		
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
					<c:if test="${empty qno}">
						<tr>
							<td id="title">작성자</td>
							<td>${NAME}</td>
						</tr>
						<tr>
							<td id="title">제 목</td>
							<td>
								<input name="qtt" type="text" size="70"maxlength="100" id="qtt2"/>
							</td>
						</tr>
						<tr>
							<td id="title">내 용</td>
							<td>
								<textarea name="qip" cols="72" rows="20" id="qip2"></textarea>
							</td>
						</tr>
					</c:if>
					<c:if test="${not empty qno}">
							<tr>
								<td id="title">작성자</td>
								<td>${DETAIL.name}</td>
							</tr>
							<tr>
								<td id="title">제 목</td>
								<td>
									<input name="qtt" type="text" size="70"maxlength="100" id="qtt4" value="${DETAIL.qtt}"/>
								</td>
							</tr>
							<tr>
								<td id="title">내 용</td>
								<td>
									<textarea name="qip" cols="72" rows="20" id="qip4">${DETAIL.qip}</textarea>
								</td>
							</tr>
					</c:if>
						<tr align="center" valign="middle">
						<!-- 글 수정 작업시 아래 -->
						<c:if test="${not empty qno}">
							<td colspan="5">
								<input type="reset" value="작성취소" id="wcbtn"> 
								<input type="submit" value="글수정" id="modibtn"> 
								<input type="button" value="목록" id="golbtn">
							</td>
						</c:if>
						<!-- 글 작성 작업시 아래 -->
						<c:if test="${empty qno}">
						<td colspan="5">
								<input type="reset" value="작성취소" id="wcbtn"> 
								<input type="submit" value="등록" id="sbbtn"> 
								<input type="button" value="목록" id="golbtn">
							</td>
						</c:if>
						</tr>
					</table>
			</div>
		</div>
		<!-- Sidebar -->
		<div id="sidebar" style="width: 350px;">
			<div class="inner" style="width: 350px;">

				<!-- Search -->


				<!-- Menu -->
				<nav id="menu">
									<header class="major">
							   				<img class="ima_1 dtlogo" src="../images/main.png" border="0" />
							   			<a></a>
										<h2>Menu</h2>
									</header>
									<ul>
									<li><span class="opener">오세용!</span>
										<ul>
											<li><a href="/Project/info/infoCT.cls">자동차극장</a></li>
											<li><a href="/Project/info/infoCP.cls">자동차캠핑</a></li>
											<li><a href="/Project/info/infoDTC.cls">승차검진소</a></li>
										</ul>
									</li>
									<li><a href="/Project/sales/sales.cls">팝니당!</a></li>
									<li><a href="/Project/review/review.cls">리뷰당!</a></li>
									<li><a href="/Project/board/board.cls">놀러왕!</a></li>
									<li><a href="/Project/qna/qnaList.cls">물어봥?</a></li>
									</ul>
				</nav>
				
			</div>
		</div>
	</div>
</body>
</html>