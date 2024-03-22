package com.peisia.api.service.util;

import org.springframework.stereotype.Component;

@Component
public class Escape {

	
	public String escape(String text) {
		
	return escapeSpecialCharacters(text);	
		
		
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
