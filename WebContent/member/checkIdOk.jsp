<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="../js/bootstrap.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="../js/respond.js"></script>
<!-- 부트스트랩 -->
<link href="../css/bootstrap.css" rel="stylesheet" media="screen">
<link href="../css/GiveBox.css" rel="stylesheet" media="screen">
<script type="text/javascript">
function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}
</script>
<div class="container box">
<h3>${id }는 사용 가능한 아이디 입니다.</h3>
<br>
<input class="btn btn-info" type="button" value="사용하기" onClick="checkIdClose('${id }')">
</div>