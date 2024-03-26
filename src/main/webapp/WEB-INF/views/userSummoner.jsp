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
	<div id="top">
		<div class="container">
			<div id="header">
				<div id="headerLeft">
					<div id="iconBox"></div>
					<div id=headerMideBox>
						<div id="gameNameTagBox">
							<div id="NameBox"></div>
							<div id="TagBox"></div>
						</div>
						<div id="nameBox"></div>
						<div id="updateBox"></div>
					</div>
				</div>
				<div id="headerRight"></div>
			</div>
		</div>
		<div id="bot">
			<div class="container">
				<div id="main">
					<div id="sidebar">
						<c:forEach var="queue" items="${queueType}">
							<c:choose>
								<hr>
								<c:when test="${queue == 1}">
									<div class="solo">솔로랭크</div>
								</c:when>
								<c:when test="${queue == 2}">
									<div class="flex">자유랭크</div>
								</c:when>
								<c:when test="${queue == 0}">
									<div class="unranked">Unranked</div>
								</c:when>
							</c:choose>
						</c:forEach>
						<div class="paging">여기에 시즌 판수 등 넣어둘꺼 아직은 안넣음</div>
					</div>
					<div class="content">
						<div class="contentHeader">큐타입 설정하는거 만들곳</div>
						<div class="matchInfoList">



							<c:forEach var="matchInfo" items="${Match}">
								<div class="matchLog">
								<div class="matchBox">
									<div class="matchLeft">
										<div class="matchLeftTop">게임종류 + 몇시에 했는지</div>
										<div class="matchLeftBot">승패 + 게임을 얼마나 했는지</div>
									</div>
									<div class="matchMide">
										<div class="matchMideTop">
											<div class="matchMideTopLeft">
												<div class="myChampionIcon">
													챔피언 아이콘 보이게
													<div class="championLevel">챔피언 레벨 보이게</div>
												</div>
												<div class="spells">
													<div class="spell">d키 스펠</div>
													<div class="spell">f키 스펠</div>
												</div>
												<div class="roons">
													<div class="roon">주 룬</div>
													<div class="roon">부 룬</div>
												</div>
												<div class="score">
													<div class="kda">
														<p class="kill"></p>
														<p class="slash"></p>
														<p class="death"></p>
														<p class="slash"></p>
														<p class="assist"></p>
													</div>
													<div class="grade">
														<p class="gradeFont">평점</p>
													</div>
												</div>
											</div>
											<div class="matchMideTopRight">
												<p class="killInvolvementRate"></p>
												<p class="perMinuteCS"></p>
												<p class="gameRankTier"></p>
											</div>
										</div>
										<div class="mideBot">
											<div class="itemList">
												<div class="item_1"></div>
												<div class="item_2"></div>
												<div class="item_3"></div>
												<div class="item_4"></div>
												<div class="item_5"></div>
												<div class="item_6"></div>
												<div class="accessories"></div>
											</div>
										</div>
									</div>
									<div class="matchRight">
										<c:forEach var="matchTeam" items="${matchInfo.getInfo().getParticipants()}">
											<c:if test="${matchTeam.getTeamId() == 100}}">
												<div class="teamList">
													${matchTeam.getRiotIdGameName()}
												</div>
											</c:if>
											<c:if test="${matchTeam.teamId == 200}">
												<div class="teamRight">
												${matchTeam.getRiotIdGameName()}
												</div>
											</c:if>
										</c:forEach>
									</div>
									<div class = "matchInfoSidebar">
										누르면 아래에 창이 생겨야함
									</div>
									</div>
									<div class = "matchDetailedInfo">
									<div class = "detailedList">
									<div class = "detailedInfo">종합</div>
									<div class = "detailedInfo">팀분석</div>
									<div class = "detailedInfo">빌드</div>
									<div class = "timeLog">etc</div>
									</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="wide-box"></div>
					</div>
				</div>
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