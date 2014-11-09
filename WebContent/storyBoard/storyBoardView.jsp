<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>GiveBox :  스토리게시판</title>
<div class="container box text-center" style="margin-top: 100px;margin-bottom: 100px;">
		<table class="table">
	        <tr><td>
	            <h2>${storyBoardDTO.subject}</h2>
	            작성 날짜&nbsp;:&nbsp;${storyBoardDTO.subject}&nbsp;&nbsp;
	            작성자&nbsp;:&nbsp;${storyBoardDTO.subject}
	        </td></tr>
	        <tr><td>
	            <img class="col-xs-8" src="/storage/${storyBoardDTO.image1 }">
	            <span class="col-xs-4">${storyBoardDTO.subject}</span>
	        </td></tr>
	        <tr><td></td></tr>
	    </table>
		<br> <input class="btn btn-info" type="button" value="목록"
			onclick="javascript:location.href='/storyBoard/storyBoardList.do?pg=${pg}'">

		<c:if test="${storyBoardDTO.id==memId }">
			<input class="btn btn-info" type="button" value="글삭제"
				onclick="javascript:del('${storyBoardDTO.seq}','${pg}')">
		</c:if>
</div>








