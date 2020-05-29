$(document).ready(function() {
     document.querySelector('.img__btn').addEventListener('click', function(){
     document.querySelector('.cont').classList.toggle('s--signup');
     
     });
   
     
     $('#lbtn').click(function(){
         // 할일
         // 1. 데이터 읽고
         var sid = $('#id').val();
         var spw = $('#pw').val();
         // 2. 유효성 검사하고
         if(!sid){
            $('#id').focus();
            return;
         }
         if(!spw){
            $('#pw').focus();
            return;
         }

         $('#frm').attr('method', 'POST');
         $('#frm').attr('action', '/Project/member/loginProc.cls');
         $('#frm').submit();
      });

      
      // 홈 버튼 처리
      $('#hbtn').click(function(){
         $(location).attr('href', '/Project/main.cls');
      });
      
    	  var sid = $('#email').val();
      //회원가입 아이디 정규식 처리
      $('#pbtn').click(function() {
    	  var spw = $('#pwe').val();
    	  var spwa = $('#pwa').val();
    	  var name = $('#idx').val();
    	  var phone = $('#phone').val();
    	  var birth = $('#birth').val();
    	  
    	     if (!isPw(spw)) {
    	    	alert('비밀번호 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내');
    	    	return;
    	     } else if(spw != spwa) {
    	    	alert('기존비밀번호와 새비밀번호가 다릅니다.');
    	    	return false;
    	     } else if (!isName(name)) {
    	    	alert('이름은 한글2~4글자로 입력해주세요.'); 
    	    	return;
    	     } else if (!isPhone(phone)) {
    	    	 alert('핸드폰 번호를 다시입력해주세요. ex) 01012345678');
      			$('#Phone').focus();
      			return;
    	     } else if (!isBir(birth)) {
    	    	 alert('생년월일 8자리를 입력해주세요. ex)19921102');
    	    	 return;
    	     } 
    	     
         $('#frm1').attr('method', 'POST');
         $('#frm1').attr('action', '/Project/member/joinProc.cls');
         $('#frm1').submit();
         alert('회원가입을 축하합니다.');
         
      });
      
      
      
      // 아이디 찾기
      $('#findid').click(function(){
    	  $(location).attr('href','/Project/member/IdFindForm.cls');
      })
      
      // 비밀번호 찾기
      $('#findpw').click(function (){
    	  $(location).attr('href','/Project/member/PassFindForm.cls');
      })
      
      
      
   // 이메일 체크 정규식
	
      function isEmail(id) {

      	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

      	return regExp.test(id); // 형식에 맞는 경우 true 리턴	

      }
      
   // 비밀번호 정규식
   	   function isPw(pw) {
	   
   		var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[*!@#$%^&+=]).*$/;
   		
   		return regex.test(pw);
   }
   
   // 이름 정규식
   		function isName(na) {
	    var name = /^[가-힣]{2,4}$/;
	    return name.test(na);
   }
   
   // 핸드폰번호 정규식
   		function isPhone(ph) {
	   var phone = /(^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})$/;
	   
	   return phone.test(ph);
   }
   
   // 생년월일 정규식
   		function isBir(bi) {
	   var bir = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
		return bir.test(bi);
   }
   
   		$('#idck').click(function(){
			// 할일
			// 1. 입력태그에 입력된 아이디를 가져오고
			var sid = $('#email').val();
			if(sid){
				$.ajax({
					url: '/Project/member/id.ck',
					type: 'post',
					dataType: 'json',
					data: {
						'email': sid
					},
					success: function(data){
						var result = data.cnt;
						if(result == 0 && isEmail(sid)){
							// 아이디를 사용가능한 경우
							alert('사용가능한 아이디입니다.');
							
						} else {
							// 아이디가 사용불가능한 경우
							alert('사용 불가능한 아이디입니다.');
							$('#email').val('');
							$('#email').focus();
						}
					},
					error: function(){
						alert('### 통신 실패 ###');
					}
				});
			} else {
				$('#email').focus();
				return;
			}
		});
		
		$('#jbtn').click(function(){
			// 데이터 무결성 검사하고
			
			$('#frm').submit();
		});
   
   
});
     