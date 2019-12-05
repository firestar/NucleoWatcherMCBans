package com.nucleocore.watch.services.mesh;

import com.nucleocore.watch.services.NucleoDataNew;
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
        NucleoData innerData = (NucleoData) data.getObjects().get("root");
        innerData.latestObjects();
        innerData.getObjects().getChanges().clear();
        this.template.convertAndSend("/topic/complete", new NucleoDataNew(innerData));
        return data;
    }
}
