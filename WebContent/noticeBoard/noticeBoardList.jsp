<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>GiveBox :  공지사항게시판</title>
<script>
	function boardPaging(pg) {
		location.href = "/noticeBoard/noticeBoardList.do?pg=" + pg;
	}

	function loginCheck(memId, seq, pg) {
		if (memId == "") {
			alert("먼저 로그인하세요");
		} else {
			location.href = "/noticeBoard/noticeBoardView.do?seq=" + seq
					+ "&pg=" + pg;
		}
	}
</script>
<div class="container box" style="margin-top: 100px;margin-bottom: 100px;">
	<div>
		<c:if test="${memId=='admin' }">
			<input  type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/noticeBoard/noticeBoardWriteForm.do'">
		</c:if>
	</div>
	<table class="table table-hover">
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회</th>
		</tr>
		<c:forEach var="noticeBoardDTO" items="${list }">
			<tr>
				<td>${noticeBoardDTO.seq}</td>
				<td><a href="#" onclick="loginCheck('${sessionScope.memId}','${noticeBoardDTO.seq}','${pg }')">
						${noticeBoardDTO.getSubject()} </a></td>
				<td>${noticeBoardDTO.id}</td>
				<td>${noticeBoardDTO.logtime}</td>
				<td>${noticeBoardDTO.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="text-center"><ul class="pagination">${noticeBoardPaging.pagingHTML }</ul></div>
</div>