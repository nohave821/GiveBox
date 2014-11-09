<%@ page language="java" contentType="text/html; charset=UTF-8"
                  pageEncoding="UTF-8"%>
<title>GiveBox :  공지사항게시판</title>
<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px;">
	<h3>작성하신 글을 저장하였습니다 2초뒤 글목록으로 이동합니다</h3>
</div>
<script type='text/javascript'>
	setTimeout("location.href='/noticeBoard/noticeBoardList.do?pg=1'",2000);
</script>