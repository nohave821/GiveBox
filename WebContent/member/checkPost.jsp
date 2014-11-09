<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
function checkPostClose(zipcode,address){
	opener.document.writeForm.zipcode.value=zipcode;
	opener.document.writeForm.addr1.value=address;
	window.close();
	opener.document.writeForm.addr2.focus();
}
</script>
<style>
	.abc {font-size:10pt; font-weight:bold;}
	
	.xyz {font-size:8pt}
	
	a:link { color:black; text-decoration:none; }
	a:visited { color:black; text-decoration:none; }
	a:hover { color:green; text-decoration:underline;}
	a:active { color:black; text-decoration:none; }
</style>
<form name="" class="abc" method="post" action="/member/checkPost.do">
	<div class="container box">
	동 입력 : <input type="text" name="dong">
	<input class="btn btn-info" type="submit" value="검색">
	<br><br>
	<table>
		<tr>
			<td colspan="5" bgcolor="#777777"  height="1"></td>
		</tr>
		<tr>
			<th width="20%" class="xyz">우편번호</th>
			<th class="xyz">주소</th>
		</tr>
		<tr>
			<td colspan="5" bgcolor="#777777"  height="1"></td>
		</tr>
			<c:forEach var="zipcodeDTO" items="${requestScope.list}">
				<c:set var="address" value="${zipcodeDTO.sido} ${zipcodeDTO.gugun} ${zipcodeDTO.dong} ${zipcodeDTO.ri}"/>
				<tr>
					<td align="center" class="xyz">${zipcodeDTO.zipcode}</td>
					<td class="xyz">
					<a href="#" onclick="checkPostClose('${zipcodeDTO.zipcode}','${address}')">${address} ${zipcodeDTO.bunji}</a>
					</td>
				</tr>
				<tr>
					<td colspan="5" bgcolor="#777777"  height="1"></td>
				</tr>
			</c:forEach>
	</table>
</div>
</form>