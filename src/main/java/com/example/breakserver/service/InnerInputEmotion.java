package com.example.breakserver.service;

import lombok.Data;

@Data
public class InnerInputEmotion {
	String type="PLAIN_TEXT";
	String language="ja";
	String content;
	InnerInputEmotion(String content){
		this.content=content;
	}
}
