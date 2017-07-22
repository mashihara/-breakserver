package com.example.breakserver.controller;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.example.breakserver.domain.Message;
import com.example.breakserver.domain.MessagingError;
import com.example.breakserver.domain.Voice;

@Controller
public class ChatController {
	@MessageMapping("/comments") // エンドポイントの指定
    @SendTo("/topic/comments") // メッセージの宛先を指定
    public Voice greeting(Voice voice) {
		return voice;
    }
	
    @MessageExceptionHandler
    @SendToUser("/queue/errors") // 送信者のみを宛先にする
    public MessagingError handleException(Throwable exception) {
        MessagingError error = new MessagingError();
        error.setMessage(exception.getMessage());
        return error;
    }
}