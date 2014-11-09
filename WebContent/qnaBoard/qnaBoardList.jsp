<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>GiveBox :  QnA게시판</title>
<script>
	function boardPaging(pg) {
		location.href = "/qnaBoard/qnaBoardList.do?pg=" + pg;
	}

	function loginCheck(memId, seq, pg) {
		if (memId == "") {
			alert("먼저 로그인하세요");
		} else {
			location.href = "/qnaBoard/qnaBoardView.do?seq=" + seq
					+ "&pg=" + pg;
		}
	}
</script>
<div class="container box" style="margin-top: 100px;margin-bottom: 100px;">
	<div><c:if test="${memId!=null}">
		<input  type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/qnaBoard/qnaBoardWriteForm.do'">
	</c:if></div>
	<table class="table table-hover">
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회</th>
		</tr>

		<c:forEach var="qnaBoardDTO" items="${list }">
			<tr>
				<td>${qnaBoardDTO.seq}</td>
				<td><c:forEach var="i" begin="1" end="${qnaBoardDTO.lev }" step="1">
		&nbsp;
	</c:forEach>
					<c:if test="${qnaBoardDTO.pseq!=0 }">
						<img src="../image/reply.gif">
					</c:if> <a href="#"
					onclick="loginCheck('${sessionScope.memId}','${qnaBoardDTO.seq}','${pg }')">
						${qnaBoardDTO.getSubject()} </a></td>
				<td>${qnaBoardDTO.id}</td>
				<td>${qnaBoardDTO.logtime}</td>
				<td>${qnaBoardDTO.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="text-center"><ul class="pagination">${qnaBoardPaging.pagingHTML }</ul></div>
</div>










