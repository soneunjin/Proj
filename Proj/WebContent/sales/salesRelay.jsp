<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/Project/assets/css/w3.css">
<script type="text/javascript" src="/Project/assets/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">
	$(function(){
		alert('${IMG}');
			$('#frm').submit();
	});
</script>
</head> 
<body>
	<form method="post" action="/Project/sales/sales_inside.cls" id="frm">
		<input type="hidden" name="pno"  value="${PNO}">
		<input type="hidden" name="ptt"  value="${DATA.ptt}">
		<input type="hidden" name="pbd"  value="${DATA.pbd}">
		<input type="hidden" name="today"  value="${DATA.today}">
		<input type="hidden" name="bcnt"  value="${DATA.bcnt}">
		<input type="hidden" name="bloc"  value="${DATA.bloc}">
	 <input type="hidden" name="memid"  value="${ID}"> 
		<input type="hidden" name="img"  value="${IMG}">
		<input type="hidden" name="car"  value="${CAR}">
		
	</form>
</body>
</html>