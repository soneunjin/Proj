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
		<%-- <input type="hidden" name="cate"  value="${DATA.cate}">
		<input type="hidden" name="rno"  value="${DATA.rno}">
		<input type="hidden" name="rtt"  value="${DATA.rtt}">
		<input type="hidden" name="rbd"  value="${DATA.rdb}">
		<input type="hidden" name="memno"  value="${DATA.memno}">
		<input type="hidden" name="rst"  value="${DATA.rst}">
		<c:if test="${not empty DATA.file}">
			<c:forEach var="data" items="${DATA.file}">
				<input type="hidden" name="imgno" value="${data.imgno}">
				<input type="hidden" name="oriname" value="${data.oriname}">
				<input type="hidden" name="savename" value="${data.savename}">
			</c:forEach>
		</c:if> --%>
	</form>
</body>
</html>