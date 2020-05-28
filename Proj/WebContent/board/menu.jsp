<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/Project/css/w3.css">
<link rel="stylesheet" href="/Project/css/board.css">
<link rel="stylesheet" href="/Project/assets/css/main.css" />
<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.edt').click(function() {
			
			window.open("", "d", "width=730, height=300, left=200, top=200");
			$('#cmfrm').attr("target", "d");
			$('#cmfrm').attr('action', '/Project/board/boardCommentEditProc.cls');
			
			$('#cmfrm').submit();
			window.close();
		});
		$('.del').click(function() {
			$('#cmfrm').attr('action', '/Project/board/boardDelete.cls');
			$('#cmfrm').submit();
			opener.parent.location.reload();
			window.close();
		});
	});
</script>
</head>
<body  class=" w3-khaki"><c:if test="${SID eq DATA.memid}">
	<div style="width: 200px" class = " w3-center w3-container w3-center w3-half w3-margin w3-padding">
		<input class = "edt" type="button" value="수정" >	<input class = "del" type="button" value="삭제" > 		
			
	</div></c:if>
	<c:if test="${SID ne DATA.memid}">
	<h2 class="w3-center w3-red">계정이 다릅니다.
	</h2></c:if>
					<form method="post" action="" id="cmfrm">
						<input type="hidden" name="no" id="no" value="${bdno}">
						<input type="hidden" name="bd" id="bd" value="${cobd}">
					</form>
</body>
</html>