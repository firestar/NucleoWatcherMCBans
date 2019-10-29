package com.nucleocore.watch.services.mesh;

import com.synload.nucleo.event.NucleoClass;
import com.synload.nucleo.event.NucleoData;
import com.synload.nucleo.event.NucleoEvent;

@NucleoClass
public class WatchRoot {
    @NucleoEvent("_watch")
    public NucleoData root(NucleoData data){
        return data;
    }
}
