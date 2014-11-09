<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>GiveBox :  QnA게시판</title>
<script type="text/javascript" >
	function boardReplyCheck(){
		if (document.qnaBoardReplyForm.subject.value=="")
			alert ("제목을 입력하세요");
		else if (document.qnaBoardReplyForm.content.value=="")
			alert ("내용을 입력하세요");
		else
			document.qnaBoardReplyForm.submit();
	}
</script>
<form name="qnaBoardReplyForm" method="post" action="/qnaBoard/qnaBoardReply.do">
	<input type="hidden" name="pseq" value="${pseq}">
	<input type="hidden" name="pg" value="${pg}">
	<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px; padding: 30px;">
		<h3>답글쓰기</h3>
		<table class="table table-hover" style="margin: auto;">
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="subject" size="49"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textArea class="form-control" name="content" cols="50"rows="15" style="resize: none;"></textArea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input class="btn btn-info" type="button" value="답글쓰기" onclick="boardReplyCheck()">
					<input class="btn btn-info" type="reset" value="다시작성" >
				</td>
		</table>
	</div>
</form>