<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>GiveBox :  스토리게시판</title>
<script type="text/javascript">
	function storyBoardCheck() {
		if (document.storyBoardWriteForm.subject.value == "")
			alert("제목을 입력하세요");
		else if (document.storyBoardWriteForm.content.value == "")
			alert("내용을 입력하세요");
		else if (document.storyBoardWriteForm.img.value == "")
			alert("이미지를 넣어주세요");
		else
			document.storyBoardWriteForm.submit();
	}
</script>
<form name="storyBoardWriteForm" method="post" encType="multipart/form-data" action="/storyBoard/storyBoardWrite.do">
	<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px; padding: 30px;">
			<h3>글쓰기</h3>
			<table class="table table-hover" style="margin:auto;">
				<tr>
					<td align="center">제목</td>
					<td><input type="text" class="form-control" name="subject"></td>
				</tr>
				<tr>
					<td align="center">목표 금액</td>
					<td><input type="text" class="form-control" name="endmoney"></td>
				</tr>
				<tr>
					<td align="center">내용</td>
					<td><textarea class="form-control" name="content" rows="10" style="resize: none;"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="file" name="img" size="45">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input class="btn btn-info" type="button" value="등록" onclick="storyBoardCheck()">
					<input class="btn btn-info" type="reset" value="취소"></td>
				</tr>
			</table>
	</div>
</form>