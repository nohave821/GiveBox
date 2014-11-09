<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GiveBox :  회원가입</title>
<script type="text/javascript" src="script.js"></script>
<form name="writeForm" method="post" action="/member/write.do">
	<div class="container box" style="margin-top: 100px;margin-bottom: 100px;">
	<h3 class="text-center col-md-8 col-sm-8">회원가입</h3>
		<table class="table" style="margin:auto;">
			<tr>
				<th width="80px">이름</th>
				<td><div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="text" name="name">
					</div></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="text" name="id"> <input
							class="btn btn-info" type="button" value="중복체크"
							onclick="checkId()">
					</div> <input type="hidden" name="check" value=""></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="password" name="pwd" size="30">
					</div></td>
			</tr>
			<tr>
				<th>재확인</th>
				<td><div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="password" name="repwd"
							size="30">
					</div></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><div class="col-md-6">
						<input type="radio" name="gender" value="0" checked>남자
						<input type="radio" name="gender" value="1">여자
					</div></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<div class="col-md-3 col-sm-3 col-xs-6" style="margin:0px">
						<input class="form-control" type="text" name="email1">
					</div>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<select class="form-control" style="width: 130px" name="email2">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
						</select>
					</div>
				</td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td>
					<div class="col-md-12">
						<select class="form-control col-md-3 col-sm-3 col-xs-3"
							style="width: 80px" name="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="019">019</option>
						</select> <span class="text-center col-md-1 col-sm-1 col-xs-1">-</span> <input
							class="form-control col-md-2 col-sm-2 col-xs-2"
							style="width: 70px" type="text" name="tel2" size="7"> <span
							class="text-center col-md-1 col-sm-1 col-xs-1">-</span> <input
							class="form-control col-md-2 col-sm-2 col-xs-2"
							style="width: 70px" type="text" name="tel3" size="7">
					</div>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="text" name="zipcode" size="7"
							readonly>
					</div>
					<div class="col-lg-3 col-md-5 col-sm-6">
						<input class="form-control" type="text" name="addr1" size="50"
							readonly>
					</div>
					<div class="col-md-2">
						<input class="btn btn-info" type="button" value="우편번호"
							onclick="checkPost()">
					</div>
					<div class="col-lg-5 col-md-7 col-sm-8" id="addr2">
						<input class="form-control" type="text" name="addr2" size="50">
					</div></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input class="btn btn-info"
					type="button" value="회원가입" onclick="javascript:checking()">
					<input class="btn btn-info" type="reset" value="다시작성"></td>
			</tr>
		</table>
	</div>
</form>