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
		$('.asbtn').click(function() {
			$('#cfrm').attr('action', '/Project/board/boardCommentEdit.cls' );
			$('#cfrm').submit();
			window.close();
			opener.parent.location='Project/board/boardDetail.cls'
		});
	});
</script>
</head>
<body class="w3-khaki">
	<div>

		<div class="w3-container w3-margin-top">
			<button class="w3-left">댓글입력</button>
			<button class="w3-right asbtn">수정</button>
			<form id="cfrm" method="post" action="">
				<input type="hidden" name="bdno" id="bdno" value="${no}" >${no}
				<textarea class="comment" name="comment" id="comment"
					style="width: 700px; height: 180px;" type="text" col="60" row="5">${bd}</textarea></form>
		</div>
		
	</div>

</body>
</html>