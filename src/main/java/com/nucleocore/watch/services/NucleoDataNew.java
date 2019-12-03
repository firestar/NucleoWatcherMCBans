package com.nucleocore.watch.services;

import com.synload.nucleo.data.NucleoData;
import com.synload.nucleo.data.NucleoObject;

import java.util.Map;

public class NucleoDataNew extends NucleoData {
    public NucleoDataNew(NucleoData data) {
        super(data);
    }

    public Map getObject(){
        return this.getObjects().getObjects();
    }
}
