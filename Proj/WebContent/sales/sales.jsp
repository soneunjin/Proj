<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>팝니당</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/Project/assets/css/main.css" />
<link rel="stylesheet" href="/Project/assets/css/sales.css" />
<link rel="stylesheet" href="/Project/assets/css/w3.css" />
<script type="text/javascript" src="/Project/assets/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/assets/js/sales.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$('.opener').click(function(){
			$(location).attr('href', '/Project/info/infoCT.cls');
		});
		
		$('.btn').click(function() {
			var tid = $(this).attr('id');
			alert(tid);
			var url = '';
			if(tid == 'login') {
				url = '/Project/member/login.cls';
			} else if (tid == 'logout') {
				url = '/Project/member/logoutProc.cls';
			} 
			
			$(location).attr('href', url);
		});
		$('.saleslist').click(function(){
			var sno = $(this).attr('id');
			$('#pno').val(sno);
			$('#nowPage').val('${PAGE.nowPage}');
			$('#frm').attr('action', '/Project/sales/sales_insideProc.cls');
			$('#frm').submit();
		});
		
		$('.pbtn').click(function(){
			var str = $(this).text();
			$('#nowPage').val(str);
			$('#frm').attr('action', '/Project/sales/sales.cls');
			$('#frm').submit();
		});
		
		$('.pbtn').click(function(){
			var str = $(this).html();
			if(str == 'PRE'){
				$('#nowPage').val('${PAGE.startPage - 1}');
			} else if(str == 'NEXT'){
				$('#nowPage').val('${PAGE.endPage + 1}');
			} else{
				return;
			}
			$('#frm').attr('action', '/Project/sales/sales.cls');
			$('#frm').submit();
		});
		
		$('#swrite').click(function(){
			$(location).attr('href','/Project/sales/sales_write.cls');
		});
		
		$('.gohome').click(function(){
			$(location).attr('href','/Project/main.cls');
		});
	});
</script>
<body class="is-preload">
   <form method="post" action="" id="frm">
		<input type="hidden" name="nowPage" id="nowPage">
		<input type="hidden" name="pno" id="pno">
	</form>
   <!-- Wrapper -->
   <div id="wrapper">
      <!-- Main -->
      <div id="main">
         <div class="inner">
            <!-- Header -->
            <header id="header">
               <a href="/Project/sales/sales.cls" class="logo"><strong>Sales Page</strong></a>

               <div class="icons">
                  	<c:if test="${empty SID}">
						<div class="btn w3-button" id="login"><b><span>SIGN IN</span></b></a></div>
					</c:if>
					<c:if test="${not empty SID}">
						<div class="btn w3-button" id="logout"><b><span>SIGN OUT</span></b></a></div>
					</c:if>
               </div>
            </header>
            <div class="mg30" style="padding-left: 20px;">팝니당</div>
            <hr style="margin: 10px;">
            <div id="wrap">
              
               <div id="board" style="max-width: 1500px;">
                  <div></div>
                  <thread>
                  <table id="bList" style="">
                     <tr style="font-size: 12pt; text-align: center;">
                        <td>글번호</td>
                        <td>제목</td>
                        <td>작성자</td>
                        <td>작성일</td>
                        <td>조회수</td>
                     </tr>
                  </thread>
                     <c:forEach var="data" items="${LIST}">
	                     <tr class="saleslist" style= "font-size: 14pt; vertical-align: middle;" id="${data.pno}">
	                        <td style="font-size: 12pt; text-align: center;" name="pno" >${data.pno}<br>
	                        <td style= "font-size: 14pt; vertical-align: middle;" name="ptt">${data.ptt}</td>
	                        <td  style= "font-size: 14pt; vertical-align: middle;" name="bceo">${data.bceo}</td>
	                        <td style= "font-size: 14pt; vertical-align: middle;" name="today">${data.today}</td>
	                        <td style= "font-size: 14pt; vertical-align: middle;" name="bcnt">${data.bcnt}</td>
                      </tr>
                      </c:forEach>
               <br> <br>
                  </table>
               
          <div class="w3-center w3-margin" >
			<div class="w3-bar w3-border">
				<c:if test="${PAGE.startPage lt (PAGE.pageGroup + 1)}">
					<span class="w3-bar-item w3-light-gray">PRE</span>
				</c:if>
				<c:if test="${PAGE.startPage ge (PAGE.pageGroup + 1)}">
					<span class="w3-bar-item w3-button w3-hover-blue pbtn pgbtn">PRE</span>
				</c:if>
				<c:forEach var="pageNo" begin="${PAGE.startPage}" end="${PAGE.endPage}">
					<span class="w3-bar-item w3-border-left w3-button w3-hover-blue pgbtn pbtn">${pageNo}</span>
				</c:forEach>
				<c:if test="${PAGE.endPage ne PAGE.totalPage}">
					<span class="w3-bar-item w3-border-left w3-button w3-hover-blue pgbtn pbtn">NEXT</span>
				</c:if>
				<c:if test="${PAGE.endPage eq PAGE.totalPage}">
					<span class="w3-bar-item w3-border-left w3-light-gray">NEXT</span>
				</c:if>
			</div>
      </div>
      		<br>
               <div id="topForm">
                  <input type="button" value="글쓰기" id="swrite">
               </div>
             
            </div>
      </div>
		</div>
         </div>
      <!-- Sidebar -->
      <div id="sidebar" style="width: 350px;">
         <div class="inner" style="width: 350px;">
            <!-- Menu -->
            <nav id="menu">
					<header class="major">
						<img class="ima_1 gohome" src="/Project/images/main.png" border="0" />
						<h2>Menu</h2>
					</header>
				<ul>
					<li>
						<span class="opener">오세용</span>
						<ul>
							<li><a href="/Project/info/infoCT.cls">자동차 극장</a></li>
							<li><a href="/Project/info/infoCP.cls">자동차 캠핌장</a></li>
							<li><a href="/Project/info/infoDTC.cls">진료소 정보</a></li>
						</ul>
					</li>
					<li><a href="/Project/sales/sales.cls">팝니당</a></li>
					<li><a href="/Project/review/review.cls">리뷰당</a></li>
					<li><a href="/Project/board/board.cls">놀러왕</a></li>
					<li><a href="/Project/qna/qnaList.cls">물어봥</a></li>
               </ul>
            </nav>
         </div>
         </div>
</body>
</html>