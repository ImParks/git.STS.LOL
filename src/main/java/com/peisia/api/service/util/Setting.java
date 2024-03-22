package com.peisia.api.service.util;

import java.net.URL;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Setting {

	RestTemplate restTemplate;
	HttpHeaders headers;
	URL url;

	public List<String> list(String text) { // 언어 불러오기

		restTemplate = new RestTemplate();
		String url = "https://ddragon.leagueoflegends.com/cdn/languages.json";

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {}
            );
        List<String> langList = responseEntity.getBody();
		return langList;

	}

	private String escapeSpecialCharacters(String text) {
		text = text.replace("\\", "\\\\"); // 백슬래시 처리
		text = text.replace("'", "\\'"); // 작은따옴표 처리
		text = text.replace("\"", "\\\""); // 큰따옴표 처리
		text = text.replace("\n", "\\n"); // 개행 문자 처리
		text = text.replace("\t", "\\t"); // 탭 문자 처리
		text = text.replaceAll("\\r|\\n", "");
		return text;
	}

}
