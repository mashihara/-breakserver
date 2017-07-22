package com.example.breakserver.service;

import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

import com.example.breakserver.domain.Voice;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MyStompService {
    private static Logger logger = Logger.getLogger(MyStompService.class);

    StompSession stompSession;

    public StompSession connect() {
        String url = "ws://localhost:8080/websocketEndpoint/0";
        
        //（1）sockJsClientの作成
        Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
        List<Transport> transports = Collections.singletonList(webSocketTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);
        //sockJsClient.setMessageCodec(new Jackson2SockJsMessageCodec());
        
        //（2）sockJsClientからstompClientの作成
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        
        //（3）connect
        StompSessionHandlerAdapter sessionHandler = new MyHandler();
        try {
        	stompSession = stompClient.connect(url, sessionHandler).get();
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return stompSession;
    }

    public void sendHello(Voice voice) {
    	if(stompSession==null){
    		connect();
    	}
        stompSession.send("/app/comments", voice);
    }

    private class MyHandler extends StompSessionHandlerAdapter {
        public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
            logger.info("Now connected");
        }
    }

}
