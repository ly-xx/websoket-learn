package com.lxxspace.web;

import com.lxxspace.demain.WiselyMessage;
import com.lxxspace.demain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author lxx
 */

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping(value = "/welcome")
    @SendTo(value = "/topic/getResponse")
    public WiselyResponse sendMessage(WiselyMessage message) throws Exception{
            Thread.sleep(3000);
            return new WiselyResponse("welcome "+ message.getName() +"!");
    }

    @MessageMapping(value = "/chat")
    public void handleChat(Principal principal,String message){
        if (principal.getName().equals("lxx")){
            template.convertAndSendToUser("ymw","/queue/notifications", principal.getName()+"-send:"+message);
        }else {
            template.convertAndSendToUser("lxx","/queue/notifications", principal.getName()+"-send:"+message);
        }
    }
}
