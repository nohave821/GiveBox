<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>GiveBox :  QnA게시판</title>
<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px;">
		<table class="table">
	        <tr><td>
	            <h2>${qnaBoardDTO.subject}</h2>
	            작성 날짜&nbsp;:&nbsp;${qnaBoardDTO.logtime}&nbsp;&nbsp;
	            작성자&nbsp;:&nbsp;${qnaBoardDTO.id}
	        </td></tr>
	        <tr><td>
	            ${qnaBoardDTO.content}
	        </td></tr>
	        <tr><td></td></tr>
	    </table>
		<br> <input class="btn btn-info" type="button" value="목록"
			onclick="javascript:location.href='/qnaBoard/qnaBoardList.do?pg=${pg}'">

		<c:if test="${qnaBoardDTO.id==memId }">
			<input class="btn btn-info" type="button" value="글삭제"
				onclick="javascript:del('${qnaBoardDTO.seq}','${pg}')">
		</c:if>
		<input class="btn btn-info" type="button" value="답글"
			onclick="javascript:location.href='/qnaBoard/qnaBoardReplyForm.do?pseq=${qnaBoardDTO.seq}&pg=${pg}'">
</div>









