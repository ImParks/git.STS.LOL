<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Layout</title>
<link rel="stylesheet" href="${cp}/resources/styles.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="headerLeft">
				<div id="iconBox"></div>
				<div id="gameNameTagBox">
					<div id="NameBox"></div>
					<div id="TagBox"></div>
				</div>
				<div id="nameBox"></div>
				<div id="updateBox"></div>
			</div>
			<div id="headerRight">
			</div>
		</div>

		<div id="main">
			<div id="sidebar">
				<div id="solo"></div>
				<div id="box"></div>
				<div id="box"></div>
				<div id="wide-box"></div>
			</div>
			<div class="content">
				<div class="box"></div>
				<div class="triple-box">
					<div class="box"></div>
					<div class="box"></div>
					<div class="box"></div>
				</div>
				<div class="wide-box"></div>
			</div>
		</div>
	</div>
</body>
</html>

<!-- 	public String id;
	public String accountId;
	public String puuid;
	public String name;
	public Integer profileIconId;
	public Long revisionDate;
	public Integer summonerLevel; -->