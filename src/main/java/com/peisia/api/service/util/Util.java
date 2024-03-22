package com.peisia.api.service.util;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.peisia.api.dto.lolDto.Account;
import com.peisia.api.dto.lolDto.ChampionMastery;
import com.peisia.api.dto.lolDto.Summoner;
import com.peisia.api.dto.lolDto.MatchDto.Match;
import com.peisia.api.dto.lolDto.MatchTimeLineDto.MatchTimeLine;

@Component
public class Util {

	public final String API_KEY = "RGAPI-0b639431-7ec7-4092-9cae-3c1039c42aa9";
	public final String PAG_COUNT = "20";
	RestTemplate restTemplate;
	HttpHeaders headers;
	String respon;
	String url;
	String matchID;

	// 펍 아이디
	public Account getPuuid(String gameName, String tag) {
		Account account = null;
		restTemplate = new RestTemplate();
		url = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName + "/"
				+ tag;
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0(Windows NT 10.0; Win64; x64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "ko-KR, ko;q=0.9,en-US;q=0.8,en;q=0."
				+ "7");
		headers.set("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);
		try {
			ResponseEntity<Account> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<>(headers), Account.class);
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				account = responseEntity.getBody();
				System.out.println("Response Body: " + account.getPuuid());

			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptionss
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return account;

	}

	public Summoner getSummoner(String puuid) {
		Summoner summoner = null;
		restTemplate = new RestTemplate();
		url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + puuid;
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		headers.set("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);

		try {
			ResponseEntity<Summoner> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<>(headers), Summoner.class);
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				summoner = responseEntity.getBody();
			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptions
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return summoner;

	}

	public List<ChampionMastery> getChampionMastery(String puuid) {
		List<ChampionMastery> ChampionMastery = null;
		restTemplate = new RestTemplate();
		url = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + puuid;
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		headers.set("Accept-Charset", "https://developer.riotgames.com");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);

		try {
			ResponseEntity<List<ChampionMastery>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<>(headers), new ParameterizedTypeReference<List<ChampionMastery>>() {
					});
			if (responseEntity.getStatusCode().is2xxSuccessful()) {

				ChampionMastery = responseEntity.getBody();
			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptions
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return ChampionMastery;
	}

//																	현제 페이지 , 한페이지당 매치 수
	public List<String> getMatchID(String puuid, int page) {
		List<String> list = null;
		restTemplate = new RestTemplate();
		url = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=" + page + "&count="
				+ PAG_COUNT;
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		headers.set("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);

		try {
			ResponseEntity<List<String>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<>(headers), new ParameterizedTypeReference<List<String>>() {
					});
			if (responseEntity.getStatusCode().is2xxSuccessful()) {

				list = responseEntity.getBody();
			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptions
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return list;

	}

	public Match getMatch(String matchid) {
		Match match = null;
		restTemplate = new RestTemplate();
		matchID = matchid;
		url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchID;
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "kko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		headers.set("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);

		try {
			ResponseEntity<Match> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					Match.class);
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				match = responseEntity.getBody();
			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptions
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return match;

	}

	public MatchTimeLine getMatchTimeLine(String matchid) {

		MatchTimeLine matchTimeLine = null;
		restTemplate = new RestTemplate();
		matchID = matchid;
		url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchID + "/timeline";
		headers = new HttpHeaders();
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
		headers.set("Accept-Language", "kko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		headers.set("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.set("Origin", "https://developer.riotgames.com");
		headers.set("X-Riot-Token", API_KEY);

		try {
			ResponseEntity<MatchTimeLine> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<>(headers), MatchTimeLine.class);
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				matchTimeLine = responseEntity.getBody();
			} else {
				// Handle non-successful response
				System.err.println("Failed to get LOL data. Status code: " + responseEntity.getStatusCode());
				// Additional error handling code here
			}
		} catch (HttpClientErrorException e) {
			// Handle HTTP client errors (e.g., 400 Bad Request)
			System.err.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
			// Additional error handling code here
		} catch (Exception e) {
			// Handle other exceptions
			System.err.println("Error: " + e.getMessage());
			// Additional error handling code here
		}

		return matchTimeLine;

	}

}
