package com.example.breakserver.service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.breakserver.domain.Voice;


@Service
public class EmotionService {
    @Value("https://language.googleapis.com/v1/documents:analyzeSentiment?key=${google.apikey}") 
    private URI uri;
    
    public Voice getShuwaApiResult(Voice voice){
    	InputEmotion inputEmotion = new InputEmotion(voice.getVoiceContent());
    	RestTemplate restTemplate = new RestTemplate();
    	OutputEmotion outputEmotion = restTemplate.postForObject(uri, inputEmotion, OutputEmotion.class);
    	if(outputEmotion.getScore()<0.0){
    		voice.setNegativeFlg(true);
    	}
    	return voice;
    }
}
