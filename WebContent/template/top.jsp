<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.navbar-default .navbar-nav>.open>a,.navbar-default .navbar-nav>.open>a:hover,.navbar-default .navbar-nav>.open>a:focus
	{
	color: #000;
	background-color: rgba(255, 255, 255, 0.84);
}

.navbar-default {
	background-color: rgba(255, 255, 255, 0.84);
	border-color: rgba(255, 255, 255, 0.84);
}

li {
	margin-right: 20px;
}

.dropdown-menu{
	background-color: rgba(255, 255, 255, 0.84);
	border-color: rgba(255, 255, 255, 0.84);
}
</style>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" id="black" style="margin-left: 20px;margin-right: 40px;" href="/main/index.do">
			<span class="glyphicon glyphicon-camera"></span>GiveBox
		</a>

	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav">

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">INTRODUCE<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/introduce/about.do">ABOUT</a></li>
					<li class="divider"></li>
					<li><a href="/introduce/vision.do">VISION</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">BOARD<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/noticeBoard/noticeBoardList.do?pg=1">NOTICE</a></li>
					<li class="divider"></li>
					<li><a href="/projectBoard/projectBoardList.do?pg=1">COMPLETEPROJECT</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">STORY<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/storyBoard/storyBoardList.do?pg=1">STORY</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Q&amp;A<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/qnaBoard/qnaBoardList.do?pg=1">문의사항</a></li>
					<li class="divider"></li>
					<li><a href="/qnaBoard/qnaBoardDirect.do">자주묻는질문</a></li>
				</ul></li>
			<li>
				<c:if test = "${memId==null }">
				<a class="navbar-nav" data-toggle="modal" href="#myModal">&nbsp;&nbsp;&nbsp;&nbsp;Log in</a>
				</c:if>
				<c:if test = "${memId!=null }">
				<div class="navbar-nav" style="margin-top:8px;color:#777777;">
				&nbsp;&nbsp;&nbsp;&nbsp;${memId }님이 로그인
				<input type="button" class="btn btn-warning" value="로그아웃" onclick="location.href='/member/logout.do'">
				</div>
				</c:if>
			</li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>





