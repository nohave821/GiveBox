<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>GiveBox :  QnA게시판</title>
<script type="text/javascript">
	function boardWriteCheck(){
		if (document.qnaBoardWriteForm.subject.value=="")
			alert ("제목을 입력하세요");
		else if (document.qnaBoardWriteForm.content.value=="")
			alert ("내용을 입력하세요");
		else
			document.qnaBoardWriteForm.submit();
	}
</script>
<form name="qnaBoardWriteForm" method="post" action="/qnaBoard/qnaBoardWrite.do">
	<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px; padding: 30px;">
			<h3>글쓰기</h3>
			<table class="table table-hover" style="margin: auto;">
				<tr>
					<td>제목</td>
					<td><input type="text" class="form-control" name="subject"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textArea class="form-control" name="content" rows="15" style="resize: none;"></textArea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input class="btn btn-info" type="button" value="글쓰기" onclick="boardWriteCheck()">
					<input class="btn btn-info" type="reset" value="다시작성"></td>
			</table>
	</div>
</form>