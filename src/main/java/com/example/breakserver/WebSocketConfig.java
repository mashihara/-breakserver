package com.example.breakserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.example.breakserver.service.MyStompService;

@EnableWebSocketMessageBroker // WebSocketのメッセージブローカーのBean定義を有効化する
@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer { // AbstractWebSocketMessageBrokerConfigurerを継承しWebSocket関連のBean定義をカスタマイズする

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	//WebSocketのエンドポイント (接続時に指定するエンドポイント)を指定
    	for(int i=0;i<3;i++){
    		registry.addEndpoint("/websocketEndpoint/"+i).withSockJS(); 
    	}
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // アプリケーション(Controller)でハンドリングするエンドポイントのプレフィックス
        registry.enableSimpleBroker("/topic", "/queue"); // Topic(Pub-Sub)とQueue(P2P)を有効化 >>> メッセージブローカーがハンドリングする
    }
}