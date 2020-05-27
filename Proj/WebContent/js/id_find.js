	$(document).ready(function() {
		$('#sbtn').click(function() {
			$('#frm').submit();
		})
		$('#cbtn').click(function() {
			$(location).attr('href','/Project/member/login.jsp');
		});
	});
	