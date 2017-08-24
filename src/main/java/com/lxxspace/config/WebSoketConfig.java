package com.lxxspace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author lxx
 */

@Configuration
//开启使用STOMP协议来传输基于代理的消息
@EnableWebSocketMessageBroker
public class WebSoketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 注册 STOMP 协议的节点，并映射指定的 URL
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 注册一个 STOMP 的 endpoint，并执行使用 SocketJs 协议
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {// 配置消息代理
        // 广播式配置 /topic 消息代理
        registry.enableSimpleBroker("/topic","/queue");
    }
}
