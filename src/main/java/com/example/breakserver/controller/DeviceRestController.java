package com.example.breakserver.controller;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.breakserver.domain.Voice;
import com.example.breakserver.service.MyStompService;
import com.example.breakserver.service.VoiceService;

@RestController
@RequestMapping("/api")
public class DeviceRestController {
	@Autowired
	VoiceService voiceService;
	
	@Autowired
	MyStompService myStompService;
	
	@PostMapping("/voice")
	public Voice setVoice(@RequestBody Voice voice){
		myStompService.sendHello(voice);
		return voiceService.create(voice);
	}
}
