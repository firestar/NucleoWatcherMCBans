package com.nucleocore.watch.services.mesh;

import com.synload.nucleo.data.NucleoData;
import com.synload.nucleo.event.NucleoClass;
import com.synload.nucleo.event.NucleoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@NucleoClass
public class CompleteMessage {

    private static SimpMessagingTemplate template;

    public CompleteMessage(){}
    @Autowired
    public CompleteMessage(SimpMessagingTemplate template) {
        this.template = template;
    }

    @NucleoEvent("_watch.complete")
    public NucleoData completeMessage(NucleoData data){
        this.template.convertAndSend("/topic/complete", data);
        return data;
    }
}
