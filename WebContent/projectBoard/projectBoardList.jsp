<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>GiveBox :  프로젝트게시판</title>
<style type="text/css">
	.img-wrap{
		border: 3px double #898989;
		height: 400px;
		border-radius: 10px;
		text-align: center;
		padding: 20px;
		margin: 10px;
	}

	.img-wrap:hover {
		border: 3px solid #1E90FF;
	}
</style>
<div class="container box" style="margin-top: 100px;margin-bottom: 100px;">
	<div>
		<c:if test="${memId=='admin' }">
			<input  type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/projectBoard/projectBoardWriteForm.do'">
		</c:if>
	</div>
	<c:forEach var="projectBoardDTO" items="${list }">
		<div class="col-md-4">
			<div class="img-wrap">
				<a href="#" onclick="loginCheck('${sessionScope.memId}','${projectBoardDTO.seq}','${pg }')">
					<img class="col-md-12 img-thumbnail" width="200" height="200" src="/storage/${projectBoardDTO.image1 }">
					<br/>
				</a>
				<div style="font-weight: bold">${projectBoardDTO.getSubject()}</div>
				<div style="color: #777777">${projectBoardDTO.id }</div>
				<div class="progress progress-striped">
					<div class="progress-bar progress-bar-success" role="progressbar"
					     aria-valuenow="${projectBoardDTO.startmoney/projectBoardDTO.endmoney*100}" aria-valuemin="0"
					     aria-valuemax="100" style="width: ${projectBoardDTO.startmoney/projectBoardDTO.endmoney*100}%;text-align: left;">
						<c:if test="${projectBoardDTO.startmoney/projectBoardDTO.endmoney*100>=100}">
							<strong style="color: #00AFFF;margin-left: 50px;">프로젝트 모금 성공</strong>
						</c:if>
						<c:if test="${projectBoardDTO.startmoney/projectBoardDTO.endmoney*100<100}">
							<strong style="color: #00AFFF;margin-left: 50px;"><fmt:formatNumber value="${projectBoardDTO.startmoney/projectBoardDTO.endmoney}" type="percent"/></strong>
						</c:if>
					</div>
				</div>
				<div style="font-size: 11px;">
					현재 모금액:${projectBoardDTO.startmoney }
					<br/>
					목표 모금액:${projectBoardDTO.endmoney }
				</div>
				<a href="" onclick="giveCheck('${sessionScope.memId}','${projectBoardDTO.seq}')" class="btn btn-primary btn-lg" data-toggle="modal" style="margin-top: 20px;">기부 하기</a>
			</div>
		</div>
		<form class="form-inline" name="projectGiveForm${projectBoardDTO.seq}" method="post"
		      action="/projectBoard/projectBoardGive.do">
			<!-- Modal -->
			<div class="modal fade" id="giveModal${projectBoardDTO.seq}" tabindex="-1" role="dialog"
			     aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
							        aria-hidden="true">×</button>
							<h2 class="modal-title text-center">Give Box : 기부하기</h2>
						</div>
						<div class="modal-body">
							<div class="text-center">
								<input type="hidden" name="seq" value="${projectBoardDTO.seq}">
								<input type="hidden" name="pg" value="1">
								<div>
									<span class="text-left">기부금액</span>
									<input class="form-control" placeholder="기부 금액" name="startmoney" style="width:100%;">
								</div>
								<br />
								<input type="submit" class="btn btn-danger" value="기부하기">
							</div>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</form>
	</c:forEach>
	<br/>
	<div class="col-xs-12 text-center"><ul class="pagination">${projectBoardPaging.pagingHTML }</ul></div>
</div>
<script type="text/javascript">
	function boardPaging(pg) {
		location.href = "/projectBoard/projectBoardList.do?pg=" + pg;
	}
	function loginCheck(memId, seq, pg) {
		if (memId == "") {
			alert("먼저 로그인하세요");
		} else {
			location.href = "/projectBoard/projectBoardView.do?seq=" + seq
					+ "&pg=" + pg;
		}
	}
	function giveCheck(memId, seq) {
		if (memId == "") {
			alert("먼저 로그인하세요");
		} else {
			$('#giveModal'+seq).modal('show');
		}
	}
</script>