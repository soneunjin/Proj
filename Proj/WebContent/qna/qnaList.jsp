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
<link rel="stylesheet" href="/Project/css/qna.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/qnaList.js"></script>
</head>

<style type="text/css">
</style>

<script type="text/javascript">
        $(function(){
        	$('.opener').click(function(){
        		$(location).attr('href','/Project/info/infoCT.cls')
        	});
        	
        	$('#wbtn').click(function(){
        		$('#frm').attr('action','/Project/qna/qnaWrite.cls');
        		$('#frm').submit();
        	});
        	
        	$('.dtlogo').click(function(){
        		alert('홈으로 드루와~');
        		$(location).attr('href', '/Project/main.cls');
        	});
        	
        	$('.ebtn').siblings().click(function(){
        		var sid = $('#sid').val();
        		var qno = $(this).parent().attr('id');
        		$('#qqno').val(qno);
        		$('#sid1').val(sid);
        		$('#dfrm').attr('action', '/Project/qna/qnaDetail.cls');
        		$('#dfrm').submit();
        	});
        	
        	$('.pbtn').click(function(){
        		var bstr = $(this).html();
        		if(bstr == 'PRE'){
        			$('#nowPage').val('${PAGE.startPage -1}');
        		} else if(bstr == 'NEXT'){
        			$('#nowPage').val('${PAGE.endPage +1}');
        		} else {
        			$('#nowPage').val(bstr);
        		}
        		$('#frm').attr('action','/Project/qna/qnaList.cls');
    			$('#frm').submit();
        	});
        	
        	$('.search').click(function(){
        		var input = $('#input').val();
        		$('#searchinput').val(input);
        		$('#searchList').attr('action', '/Project/qna/qnaSearch.cls');
        		$('#searchList').submit();
        	});
        	
        	
        	$('.content').hover(function(){
        		$(this).css('color','brown');
        	},function(){
        		$(this).css('color','gray');
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
				  
                           <a href="/Project/main/main.jsp" class="logo"><strong>Main page</strong></a>
                           <ul class="icons">
                           <c:if test="${empty SID}">
                              <li><a href="/Project/member/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </c:if>
                           <c:if test="${not empty SID}">
                              <li><a href="/Project/member/logoutProc.cls" class="w3-col"><b><span>SIGN OUT</span></b></a></li>
                           </c:if>
                           </ul>
                      
				</header>

	<body>
				<form method="post" action="" id="frm">
					<input type="hidden" name="nowPage" id="nowPage" value="${param.nowPage}">
					<input type="hidden" name="sid" id="sid" value="${SID}">
				</form>
				<form method="post" action="" id="dfrm">
					<input type="hidden" name="sid" id="sid1" value="">
					<input type="hidden" name="qqno" id="qqno">
				</form>
					<div id="wrap" >
						<br>
						<div id="topForm">
							<div class="w3-center ftt" >Q&A</div>
							<c:if test="${sessionScope.sessionID!=null}">
							</c:if>
						</div>
						<br>
						<div id="board">
							<table id="bList">
								<tr heigh="30">
									<td>글번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>답변상태</td>
								</tr>
									<c:forEach var="data" items="${LIST}" varStatus="status">
									<tr class="content" id="${data.qno}">
										<td class="ebtn">${data.qno}</td>
										<td>${data.qtt}</td>
										<td>${data.name}</td>
										<td>${data.qDate}</td>
										<c:if test="${data.ok eq 'ok'}">
											<td>답변완료</td>
										</c:if>
										<c:if test="${data.ok ne 'ok'}">
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										</c:if>
									</tr>
									</c:forEach>
							</table>
						</div>
						<div class="w3-right">
						<c:if test="${not empty SID}">
							<input type="button" value="글쓰기" id="wbtn">
						</c:if>
						</div>
						<div class="w3-row" style="margin-bottom: -50px;"><p></p></div>
						<div class="w3-center w3-margin-left w3-padding-left">
				<div class="w3-center w3-bar w3-border">
					<c:if test="${PAGE.startPage lt 4 }">
						<span class="w3-bar-item w3-light-gray">PRE</span>
					</c:if>
					<c:if test="${PAGE.startPage ge 4 }">
						<span class="w3-bar-item w3-button w3-hover-blue pbtn">PRE</span>
					</c:if>
						<c:forEach var="pageNo" begin="${PAGE.startPage}" end="${PAGE.endPage}">
							<span class="w3-bar-item w3-border-left w3-button w3-hover-blue pbtn">${pageNo}</span>
						</c:forEach>
						<c:if test="${PAGE.endPage ne PAGE.totalPage}">
							<span class="w3-bar-item w3-border-left w3-button w3-hover-blue pbtn">NEXT</span>
						</c:if>
						<c:if test="${PAGE.endPage eq PAGE.totalPage}">
							<span class="w3-bar-item w3-border-left w3-light-gray">NEXT</span>
						</c:if>
				</div>
			</div>
						<div id="pageForm">페이지 번호</div>
						<br>
						
						<br>
						<div class="w3-col w-300" id="searchForm" >
							
							<!-- 꼭 필요할까요??? 셀렉트박스 -->
							<form method="post" action="" id="searchList">
								<input type="hidden" name="nowPage" id="nowPage" value="${param.nowPage}">
								<input type="hidden" name="input" id="searchinput">
							<div class="w3-col m2">
								<select name="type" style="margin: 10px;">
									<option value="qtt">제목</option>
									<option value="qip">내용</option>
									<option value="name">작성자</option>
								</select> 
							</div>
							<!-- ------------------------ -->
							
							<div class="w3-col m4">
								<input id="input" type="text" size="15" name="condition" style="margin: 10px;" />
							</div>
							<div class="w3-col m2">
								<input class="search" type="submit" value="search" style="margin: 10px;" />
							</div>
							</form>
						</div>
					</div>

				</body>

			</div>
		</div>
		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->


				<!-- Menu -->
					<nav id="menu">
									<header class="major">
							   				<img class="ima_1" src="../images/main.png" border="0" />
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