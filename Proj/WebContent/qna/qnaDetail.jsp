<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Q&A Detail</title>

<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/qna.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />

<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Project/js/login.js"></script>
</head>
<style type="text/css">
</style>

<script type="text/javascript">
$(function(){
	var id = $('#sid').val();
	alert(id);
	
	$('.ans').css('display', 'none');
	$('.ansresult').css('display', 'none');
	
	$('#modibtn').click(function(){
		alert('글 내용을 수정합니다');
		$('#ddfrm').attr('action','/Project/qna/qnaModi.cls');
		$('#ddfrm').submit();
	});
	
	$('#golbtn').click(function(){
		alert('Q&A 목록으로 이동합니다');
		$(location).attr('href','/Project/qna/qnaList.cls');
	});
	
	$('.dtlogo').click(function(){
		$(location).attr('href','/Project/main.cls');
	});
	
	$('#sbbtn').click(function(){
		alert('글을 삭제하고 리스트로 돌아갑니다');
		$('#ddfrm').attr('action','/Project/qna/qnaDel.cls');
		$('#ddfrm').submit();
	});
	
	$('#ansbtn').click(function(){
		alert('답변달아봅시다');
		$('.ans').css('display', '');
		
	});
	
	$('#ansmodi').click(function(){
		alert('답변 수정합시다');
      //var asno = $('#asno').val();
	  
		$('#asmodifrm').attr('action', '/Project/qna/AnsModi.cls');
		$('#asmodifrm').submit();
		
	});
	
	$('#ansdel').click(function(){
		alert('답변을 삭제합니다');
		
		$('#asmodifrm').attr('action', '/Project/qna/qnaDel.cls');
		$('#asmodifrm').submit();
	});
	
	$('#ansinput').click(function(){
     // 비동기통신으로 처리하기
		alert('답변글 등록합니다');
		var att = document.getElementById("att").value;
		alert(att);
		var abd = document.getElementById("aip").value;
		alert(abd);
		var upno = document.getElementById("qno").value;
		alert(upno);
		var sid = document.getElementById("sid").value;
		alert(sid);
			
		$.ajax({
			url: '/Project/qna/qnaAns.cls',
			type: 'POST',
			dataType: 'json',
			data:{
				"sid":sid,
				"astt":att,
				"asbd":abd,
				"qqno":upno
			},
			success: function(obj){
				var astt = obj.anstt;
				alert(astt);
				var asbd = obj.ansbd;
				alert(asbd);
				var name = obj.name;
				alert(name);
				var date = obj.adate;
				alert(date);
				$('.ansdate').html(date);
				$('.ansname').html(name);
				$('.anstt').val(astt);
				$('.ansbd').val(asbd);
				alert('글 수정이 완료되었습니다');
				$('.ans').css('display', 'none');
			    $('.ansresult').css('display', '');
			    location.reload();
			},
			error: function(){
				alert('통신실패');
			}
			
		})
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

					<a href="index.jsp" class="logo"><strong>Detail page</strong></a>
					 <ul class="icons">
                           <c:if test="${empty SID}">
                              <li><a href="/Project/member/login.jsp" class="w3-col"><b><span>SIGN IN</span></b></a></li>
                           </c:if>
                           <c:if test="${not empty SID}">
                              <li><a href="/Project/member/logoutProc.cls" class="w3-col"><b><span>SIGN OUT</span></b></a></li>
                           </c:if>
                           </ul>

				</header>

				<head>
				</head>
				<div id="wrap">
					<br> <br>
					<div id="board">
						<form method="post" action="" id="ddfrm">
							<input type="hidden" name="qqno" value="${QUEST.qno}" id="ssss">
							<input type="hidden" name="qqtt" value="${QUEST.qtt}">
							<input type="hidden" name="qqip" value="${QUEST.qip}">
							<input type="hidden" id="sid" name="sid" value="${SID}">
						</form>
						<form method="post" action="" id="asfrm">
							<input type="hidden" name="qqno" value="${qno}" id="qno">
							<input type="hidden" name="astt" id="astt">
							<input type="hidden" name="asbd" id="asbd">
							<input type="hidden" id="sid" name="sid" value="${SID}">
						</form>
						<form method="post" action="" id="asmodifrm">
							<input type="hidden" name="qqno" id="asno" value="${ANSWER.qno}">
							<input type="hidden" name="astt" id="mastt" value="${ANSWER.qtt}">
							<input type="hidden" name="asbd" id="masbd" value="${ANSWER.qip}">
							<input type="hidden" id="sid" name="sid" value="${SID}">
						</form>
						
						<!-- 아래는 Q&A 작성된 정보 보여주는 곳 -->
						<table>
						<tr>
							<td class="title">작성일</td>
							<td>${QUEST.qDate}</td>
							<td class="title">작성자</td>
							<td>${QUEST.name}</td>
						</tr>
						</table>
						<table id="detailBoard" width="50%" border="3" bordercolor="black">
							<tr>
								<td class="title">제 목</td>
							</tr>
							<tr>
								<td>${QUEST.qtt}</td>
							</tr>
							<tr>
								<td class="title">내 용</td>
							</tr>
							<tr>
								<td>${QUEST.qip}</td>
							</tr>
							
							<tr>
							</tr>
						</table>
						
						<!-- Q&A 작성된 정보 보여주는 끝 -->
						<br>
						<!-- 답변등록 버튼 클릭시 생성되는 입력창 -->
						<div class="ans">
						<table>
						<tr>
						<!-- 
							<td class="title">작성일</td>
							<td>${DETAIL.qDate}</td>
							
						 -->
							<td class="title">작성자</td>
							<td>${NAME}</td>
						</tr>
						</table>
						<table>
							<tr>
								<td class="title">답 변 제 목</td>
							</tr>
							<tr>
							<td>
								<input name="qtt" type="text" size="70" maxlength="100" placeholder="답변제목" id="att"/>
							</td>
							</tr>
							<tr>
								<td class="title">답 변</td>
							</tr>
							<tr>
								<td>
									<textarea name="qip" cols="72" rows="10" id="aip" placeholder="답변작성란"></textarea>
									<input class="w3-right" type="button"  value="답변등록" id="ansinput"> 
								</td>
							</tr>
						</table>
						</div>
							<!-- 
								답변 입력한 경우 보여지는 공간 (비동기통신처리)
							-->
						<div class="ansresult">
						<div class="w3-col w3-center w3-border w3-margin-top"><p><h3>답 변</h3></p></div>
						<table>
						<tr>
						<!-- 
						 -->
							<td class="title">작성일</td>
							<td class="ansdate"></td>
							<td class="title">작성자</td>
							<td class="ansname"></td>
						</tr>
						</table>
						<table>
							<tr>
								<td class="title">답 변 제 목</td>
							</tr>
							<tr>
							<td>
								<input class="anstt" name="qtt" type="text" size="70" maxlength="100"/>
							</td>
							</tr>
							<tr>
								<td class="title">답 변</td>
							</tr>
							<tr>
								<td>
									<textarea class="ansbd" name="qip" cols="72" rows="10" id="aip"></textarea>
								</td>
							</tr>
						</table>
						</div>
						<c:if test="${not empty ANSWER}">
						<div class="">
						<table style="margin-bottom: 0px;">
							<tr>
								<td class="title"><b>답 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  변</b></td>
							</tr>
						</table>
						<table>
						<tr>
						<!-- 
						 -->
							<td class="title">작성일</td>
							<td class="ansdate">${ANSWER.qDate}</td>
							<td class="title">작성자</td>
							<td class="ansname">${ANSWER.name}</td>
						</tr>
						</table>
						<table>
							<tr>
								<td class="title">답 변 제 목</td>
							</tr>
							<tr>
								<td>${ANSWER.qtt}</td>
							</tr>
							<tr>
								<td class="title">답 변 내 용</td>
							</tr>
							<tr>
								<td>${ANSWER.qip}</td>
							</tr>
						</table>
						</div>
						</c:if>
						<table>
							<tr align="center" valign="middle">
						<c:if test="${empty ANSWER}">
								<td colspan="5">
								<c:if test="${SID eq 'sej0267@naver.com'}">
										 <input type="button"  value="답변" id="ansbtn">
								</c:if>
								<c:if test="${SID eq QUEST.memid}">
										 <input type="button"  value="글수정" id="modibtn"> 
										 <input type="submit" value="글삭제" id="sbbtn">
										 <input type="button" value="글목록" id="golbtn">
								</c:if>
								 </td>
						</c:if>
						<c:if test="${not empty ANSWER}">
								 <td colspan="5">
								 <c:if test="${SID eq 'sej0267@naver.com'}">
									 <input type="button"  value="답변수정" id="ansmodi">
								 </c:if>
								 <c:if test="${SID eq QUEST.memid}">
										 <input type="button"  value="글수정" id="modibtn"> 
										 <input type="submit" value="글삭제" id="sbbtn">
										 <input type="button" value="글목록" id="golbtn">
								</c:if>
								</td>
						</c:if>
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
						<img class="dtlogo" src="/Project/images/main.png" width="300px"height="auto">
					</header>
					<ul>
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