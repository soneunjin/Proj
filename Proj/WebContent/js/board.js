/*
 	board.jsp
 */
$(document).ready(function() {
	$('.content').click(function() {
		// 할일
		// 글 번호 알아낸다.
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#frm').attr('action', '/Project/board/boardDetail.cls');
		$('#frm').submit();

	});
	$('.pbtn').click(function() {
		var str = $(this).text();
		$('#nowPage').val(str);

		$('#frm').attr('action', '/Project/board/board.cls');
		$('#frm').submit();
	});

	$('.tagbtn').click(function() {
		var cat = $(this).attr('id');
		$('#tab').val(cat);
		$('#tfrm').attr('action', '/Project/board/Cboard.cls');
		$('#tfrm').submit();
	});
	$('.bdh').click(function() {
		location.href = "/Project/board/board.cls"

	});
	$('#serbtn').click(function() {

		$('#search').attr('action', '/Project/board/search.cls');
		alert("갑니다.");
		$('#search').submit();

	});
	$(function() {
		/*
		 * $('#login').click(function(){ $(location).attr('href',
		 * '/Project/member/login.cls'); });
		 * 
		 * $('#logout').click(function(){ $(location).attr('href',
		 * '/clsProj/member/logoutProc.cls'); });
		 */

		$('.btn').click(function() {
			var tid = $(this).attr('id');
			var url = '';
			if (tid == 'login') {
				url = '/Project/member/login.cls';
			} else if (tid == 'logout') {
				url = '/Project/member/logoutProc.cls';
			}

			$(location).attr('href', url);
		});

	});

});
function writeForm() {
	location.href = "/Project/board/boardWrite.cls";

}

/*
 * cboard.jsp
 */

/*
 * boardDetail.jsp
 */
$(document).ready(function() {
	$('.deletedetail').click(function() {
		// 할일
		// 글 번호를 알아낸다

		$('#dtbno').attr('action', '/Project/board/boardDelete.cls');
		$('#dtbno').submit();

	});
	$('.editdetail').click(function() {
		// 할일
		// 글 번호를 알아낸다
		$('#dtfrm').attr('action', '/Project/board/boardEdit.cls');
		$('#dtfrm').submit();

	});
	$('.comment').click(function() {
		// 할일
		// 글 번호를 알아낸다

		window.open("", "a", "width=730, height=300, left=200, top=200");
		$('#dtfrm').attr("target", "a");
		$('#dtfrm').attr('action', '/Project/board/boardCommentProc.cls');
		$('#dtfrm').submit();

	});
	$('.comendetail').click(function() {
		// 할일
		// 글 번호를 알아낸다
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		window.open("", "b", "width=250px, height=130px, left=800, top=500");
		$('#frmdt').attr("target", "b");
		$('#frmdt').attr('action', '/Project/board/menu.cls');
		$('#frmdt').submit();

	});

	/*
	 * boardEdit.jsp
	 */

	$(document).ready(function() {
		$('#editbtn').click(function() {
			$('#frm').submit();
		});
		$('#hbtn').click(function() {
			alert('HOME으로 이동합니다 GoGo');
			$(location).attr('href', '/Project/main.cls')
		});
	});
	/*
	 * boardWrite
	 */
	$('#wbtn').click(function() {
		$('#frm').submit();
	});
	/*
	 * sboard.jsp
	 */
	$('.content').click(function() {
		// 할일
		// 글 번호 알아낸다.
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#nowPage').val('${PAGE.nowPage}');
		$('#frm').attr('action', '/Project/board/boardDetail.cls');
		$('#frm').submit();

	});
	$('.spbtn').click(function() {
		var str = $(this).text();
		$('#nowPage').val(str);

		$('#frm').attr('action', '/Project/board/search.cls');
		$('#frm').submit();
	});

	$('.stagbtn').click(function() {
		var cat = $(this).attr('id');
		$('#tab').val(cat);
		$('#tfrm').attr('action', '/Project/board/search.cls');
		$('#tfrm').submit();
	});

	$('#serbtn').click(function() {

		$('#search').attr('action', '/Project/board/search.cls');
		alert("갑니다.");
		$('#search').submit();

	});
	/*
	 * cboard.jsp
	 */
	$('.content').click(function() {
		// 할일
		// 글 번호 알아낸다.
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#nowPage').val('${PAGE.nowPage}');
		$('#frm').attr('action', '/Project/board/boardDetail.cls');
		$('#frm').submit();

	});
	$('.cpbtn').click(function() {
		var str = $(this).text();
		$('#nowPage').val(str);
		$('#frm').attr('action', '/Project/board/Cboard.cls');
		$('#frm').submit();
	});
//C보드 카테고리간 이동 가능하게 하기
	

	$('.ctagbtn').click(function() {
		var cat = $(this).attr('id');
		$('#tab').val(cat);
		$('#tfrm').attr('action', '/Project/board/Cboard.cls');
		$('#tfrm').submit();
	});
	/*
	 * comment.jsp
	 */
	$('.sbtn').click(function() {
		$('#cfrm').attr('action', '/Project/board/boardComment.cls' );
		opener.parent.location.reload();

		$('#cfrm').submit();
		
		window.close();
		

		
	});

});
