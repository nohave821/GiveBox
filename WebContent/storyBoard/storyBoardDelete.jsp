<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<title>GiveBox :  스토리게시판</title>
<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px;">
	<h3>글삭제를 완료 했습니다 2초뒤 글목록으로 이동합니다</h3>
</div>
<script type='text/javascript'>
	setTimeout("location.href='/storyBoard/storyBoardList.do?pg=1'",2000);
</script>