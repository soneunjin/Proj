<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>팝니당</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/Project/assets/css/main.css" />
<link rel="stylesheet" href="/Project/assets/css/w3.css" />
<script type="text/javascript" src="/Project/assets/js/jquery-3.5.0.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$('.btn').click(function() {
			var tid = $(this).attr('id');
			var url = '';
			if(tid == 'login') {
				url = '/Project/member/login.cls';
			} else if (tid == 'logout') {
				url = '/Project/member/logoutProc.cls';
			
			} 
		   });
		$('#submit').click(function(){
			var pno = $('#ppno').val();
	       $('#frm').submit();
	      });
		$('#delete').click(function(){
			   var pno = $('#pno').val();
			   alert(pno);
			   $('#frm1').attr('action', '/Project/review/review_deleteProc.cls');
			   $('#frm1').submit();
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
               <a href="/Project/main.cls" class="logo"><strong>Editorial</strong> by
                  HTML5 UP</a>

               <div class="icons">
                  <a href="/Project/login.jsp" class="">
                  	<c:if test="${empty SID}">
						<div class="btn w3-button" id="login"><b><span>SIGN IN</span></b></a></div>
					</c:if>
					<c:if test="${not empty SID}">
						<div class="btn w3-col" id="logout"><b><span>SIGN OUT</span></b></a></div>
					</c:if>
               </div>
            </header>
            <hr style="margin: 10px;">
            <div id="wrap">
               <br>
               <br>
               <div id="board" style="max-width: 1500px;">
                  <div></div>
                  <thread>
                  <form method="post" action="" name="ReviewForm" id="">
				</form> 
					<div>
					<input type="hidden" name="board_id">
						<form method="post" action="/Project/review/reviewProc.cls" name="ReviewForm" id="frm">
				    <input type="hidden" name="ppno" id="ppno" value="${PNO}" >
					<table width="700" border="3" bordercolor="lightgray"
						align="center">
						<tr>
							<td>작성자</td>
							<td id="sid">${SID}</td>
						</tr>
						<tr>
							<td>원글번호</td>
							<td id="pno" name="pno">${PNO}</td>
						</tr>
						<tr>
							<td><b>평 점</b></td>
							<td>
							<div>
								<select name="rst">
									<option value="5">5
									<option value="4">4
									<option value="3">3
									<option value="2">2
									<option value="1">1
								</select>
							</div>
							</td>
						</tr>
						<tr>
							<td>제 목</td>
							<td><input id="rtt" name="rtt" type="text" size="50"
								maxlength="100"></td>
						</tr>
						<tr>
							<td >내 용</td>
							<td><textarea style="resize: none;" id="rbd" name="rbd" cols="72" rows="20"></textarea>
							</td>
						</tr></form>
					</table>
					</div>
				<div style="position:relative; left: 40%;">
					<input type="button" id="submit" name="submit" value="등록">
				</div>
      		</div>
           </div>
      </div>
		</div>
      <!-- Sidebar -->
      <div id="sidebar">
         <div class="inner">
            <!-- Menu -->
            <nav id="menu">
					<header class="major">
						<a href="/Project/main.cls" width="0px;" height="0px;"> <img
							class="ima_1" src="/Project/images/main.png" border="0" />
						</a>
						<h2>Menu</h2>
					</header>
				<ul>
					<li><a href="/Project/sales/sales.cls">팝니당$</a></li>
					<li>
						<span class="opener">오세용~</span>
						<ul>
							<li><a href="/Project/info/infoCT.cls">자동차 극장</a></li>
							<li><a href="/Project/info/infoCP.cls">자동차 캠핌장</a></li>
							<li><a href="/Project/info/infoDTC.cls">진료소 정보</a></li>
						</ul>
					</li>
					<li><a href="/Project/board/board.cls">놀러왕!</a></li>
					<li><a href="/Project/qna/qnaList.cls">물어봥?</a></li>
					<li><a href="/Project/review/review.cls">리뷰당?</a></li>
               </ul>
            </nav>
         </div>
       </div>
         </div>
</body>
</html>