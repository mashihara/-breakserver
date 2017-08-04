package com.example.breakserver.service;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class OutputEmotion {
	Map<String,String> documentSentiment;
    String language;
    List<Sentence> sentences;
    public double getScore(){
    	return Double.valueOf(documentSentiment.get("score"));
    }
}
