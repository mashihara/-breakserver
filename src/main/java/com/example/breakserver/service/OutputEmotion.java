package com.example.breakserver.service;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class OutputEmotion {
	DocumentSentiment documentSentiment;
    String language;
    List<Sentence> sentences;
    public double getScore(){
    	return documentSentiment.getScore();
    }
}
