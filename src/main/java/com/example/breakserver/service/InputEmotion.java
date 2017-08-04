package com.example.breakserver.service;

import lombok.Data;

@Data
public class InputEmotion {
	String encodingType="UTF8";
	InnerInputEmotion document;
	InputEmotion(String content){
		this.document= new InnerInputEmotion(content);
	}
}
