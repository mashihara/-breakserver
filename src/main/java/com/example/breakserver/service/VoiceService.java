package com.example.breakserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.breakserver.domain.Voice;
import com.example.breakserver.repository.VoiceRepository;

@Service
public class VoiceService {
	@Autowired
	VoiceRepository voiceRepository;
	
	public Voice create(Voice voice){
		return voiceRepository.save(voice);
	}
}
