package com.nucleocore.watch.services.mesh;

import com.nucleocore.watch.services.NucleoDataNew;
import com.synload.nucleo.data.NucleoData;
import com.synload.nucleo.event.NucleoClass;
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
        NucleoData innerData = (NucleoData) data.getObjects().get("root");
        this.template.convertAndSend("/topic/incomplete", new NucleoDataNew(innerData));
        return data;
    }
}
