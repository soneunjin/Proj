<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/Project/css/w3.css">
<script type="text/javascript" src="/Project/js/jquery-3.5.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

<style>
	tr {
 border: 0px solid none;
}
k:hover {
 text-decoration: none;
 color: #9354ED
}
.trang{
	width: 10px;
  height: 27px;
  transition: width 1s;
  margin-bottom:10px;
  background-color: #F6F6F6;
  display: none;
 overflow: hidden; /*내용이 요소 밖으로 나가면 가려줌.*/
}
.firstDiv{
  width: 400px;
  height: 27px;
}

	button {

    width:100px;

    background-color: #f8585b;

    border: none;

    color:#fff;

    padding: 15px 0;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 15px;

    margin: 4px;

    cursor: pointer;

}
.he-10{
	height:54px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#sbtn').click(function() {
			
			var name = $('#name').val();
			var phone = $('#phone').val() + $('#phone1').val() + $('#phone2').val();
			$.ajax({
				url: '/Project/ajax/IdFindPro.abc',
				type: 'post',
				dataType: 'json',
				data: {
					'name': name,
					'phone': phone
				},
				success: function(obj) {
					$('#memid').html(obj.memid);
					
				},
				eroor: function() {
					alert('통신에러');
				}
			});
		});
	});
	
	
</script>
</head>
<body>
	<table width="1330px" height="430px" align="center">
    <tr>
     <td>
      <table width="600px" align="center" style="color: black; background-color: #F6F6F6; font-size: 20px;">
       <tr>
        <td>
         <table width="750px" align="center" style="background-color: #d4af7a; margin-top: 3%">
          <tr>
           <td align="center"></td>
           <td align="center">아이디 찾기</td>
          </tr>
         </table>
        </td>
       </tr>
       
       <tr>
        <td>
          <tr>
           <td align="center">
            <table width="300px" height="30px" border="0" style="margin-top: 3%; color: black; font-size: 18px;">
             <tr>
              <td align="center">&nbsp;이름,핸드폰번호로 찾기</td>
             </tr>
            </table>
           </td>
          </tr>
          </td>
          </tr>

          <tr>
           <td>
            <table width="380px" height="70px" align="center" border="0" style="font-size: 16px;">
             <tr>
              <td>이름</td>
              <td><input type="text" name="name" id="name"></td>
             </tr>
             <tr>
              <td>휴대폰</td>
              <td><select name="phone" id="phone">
                <option value="010" selected="selected">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
              </select> - <input type="text" name="phone1" id="phone1" style="width: 70px">
               - <input type="text" name="phone2" id="phone2" style="width: 70px"></td>
             </tr>
            </table>
           </td>
          </tr>

          <tr>
           <td>
            <table width="140px" height="10px" border="0" style="margin-top: 2%" align="center">
             <tr>
              
			<div id="ex1" class="modal">
			  	<p>고객님의 아이디는 [<span id="memid"></span>]입니다.</p>
			  	<a href="#" rel="modal:close">닫기</a>
			  
              	<td><p><a href="#ex1" id="sbtn" rel="modal:open">찾기</a></p></td>
			</div>
				
				
              <td id="cbtn"><p><a href="/Project/member/login.cls">취소</a></p></td>
            </table>
           	  </td>
             </tr>
           
         </table>
        </td>
       </tr>
      </table>
     </body>
</html>