package com.nucleocore.watch.services.mesh;

import com.synload.nucleo.event.NucleoClass;
import com.synload.nucleo.event.NucleoData;
import com.synload.nucleo.event.NucleoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@NucleoClass
public class IncompleteMessage {
    private static SimpMessagingTemplate template;

    public IncompleteMessage(){}
    @Autowired
    public IncompleteMessage(SimpMessagingTemplate template) {
        this.template = template;
    }

    @NucleoEvent("_watch.incomplete")
    public NucleoData timeoutMessage(NucleoData data){
        this.template.convertAndSend("/topic/incomplete", data);
        return data;
    }
}
