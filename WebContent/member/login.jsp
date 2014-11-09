<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkingLogin() {
		if (document.loginForm.id.value == ""){
			alert("아이디를 입력하세요.");
		}else if (document.loginForm.pwd.value == ""){
			alert("패스워드를 입력하세요.");
		}else{
			document.loginForm.submit();
		}
	}
</script>
<form class="form-inline" name="loginForm" method="post"
	action="/member/login.do">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h2 class="modal-title text-center">Log in</h2>
				</div>
				<div class="modal-body">
					<div>
						<div>
							<span>아이디&nbsp;&nbsp;&nbsp;</span>
							<input class="form-control"
								placeholder="Your ID" type="text" name="id" style="width:100%;">
						</div>
						<br />
						<div>
							<span>비밀번호</span>
							<input class="form-control"
								placeholder="Password" type="password" name="pwd" style="width:100%;">
						</div>
						<br /> <input type="button" class="btn btn-danger" value="로그인"
							onclick="javascript:checkingLogin()"> <input
							type="button" class="btn btn-danger" value="회원가입"
							onclick="location.href='/member/writeForm.do'">
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</form>