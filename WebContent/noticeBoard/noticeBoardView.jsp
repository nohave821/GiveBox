<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="script.js"></script>
<title>GiveBox :  공지사항게시판</title>
<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px;">
	<table style="margin: auto;">
		<tr>
			<td colspan="3" bgcolor="#777777"></td>
		</tr>
		<tr>
			<td colspan="6"><h4>${noticeBoardDTO.subject}</h4></td>
		</tr>
		<tr>
			<td colspan="3" bgcolor="#CCCCCC"></td>
		</tr>
		<tr>
			<td align="center">글번호 : ${noticeBoardDTO.seq}</td>
			<td align="center">작성자 : ${noticeBoardDTO.id}</td>
			<td align="center">조회 : ${noticeBoardDTO.hit}</td>
		</tr>
		<tr>
			<td colspan="3" bgcolor="#CCCCCC"></td>
		</tr>
		<tr>
			<td colspan="6"><textarea class="form-control col-xs-12"
					readonly cols='50' rows='15'>${noticeBoardDTO.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="3" bgcolor="#777777"></td>
		</tr>
	</table>
	<br>
	<input class="btn btn-info" type="button" value="목록" onclick="javascript:location.href='/noticeBoard/noticeBoardList.do?pg=${pg}'">
	<c:if test="${noticeBoardDTO.id==memId }">
		<input class="btn btn-info" type="button" value="글삭제"
			onclick="location.href='/noticeBoard/noticeBoardDelete.do?seq=${noticeBoardDTO.seq}'">
	</c:if>
</div>









