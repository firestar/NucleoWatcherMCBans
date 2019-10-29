package com.nucleocore.watch.services.mesh;

import com.synload.nucleo.event.NucleoClass;
import com.synload.nucleo.event.NucleoData;
import com.synload.nucleo.event.NucleoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@NucleoClass
public class TimeoutMessage {
    private static SimpMessagingTemplate template;

    public TimeoutMessage(){}
    @Autowired
    public TimeoutMessage(SimpMessagingTemplate template) {
        this.template = template;
    }

    @NucleoEvent("_watch.timeout")
    public NucleoData timeoutMessage(NucleoData data){
        this.template.convertAndSend("/topic/timeout", data);
        return data;
    }
}