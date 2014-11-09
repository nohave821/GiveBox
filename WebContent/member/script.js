function checking(){
	if(document.writeForm.name.value=="") 
		alert("이름을 입력하세요");
	else if(document.writeForm.id.value=="")
		alert("아이디를 입력하세요");
	else if(document.writeForm.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		alert("비밀번호를 다시 확인하세요");
	else if(document.writeForm.check.value != document.writeForm.id.value)
		alert("중복체크하세요.");
	else
		document.writeForm.submit();	
}

function checkId(){
	var sId = document.writeForm.id.value;
	
	if(sId=="") 
		alert("먼저 아이디를 입력하세요");
	else
		window.open("/member/checkId.do?id="+sId,"","width=350 height=200");
}

function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkPost(){
	window.open("/member/checkPost.do","","width=350 height=300 scrollbars=yes");
	
}

function checkPostClose(zipcode,address){
	opener.document.all.zipcode.value=zipcode;
	opener.document.all.addr1.value=address;
	window.close();
	opener.document.all.addr2.focus();
	
}















