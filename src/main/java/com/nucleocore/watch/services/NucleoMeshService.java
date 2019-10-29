package com.nucleocore.watch.services;

import com.synload.nucleo.NucleoMesh;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NucleoMeshService {
  public static String getEnv(String env, String default_value){
    String temp = System.getenv(env);
    if(temp!=null){
      return temp;
    }
    return default_value;
  }
  @PostConstruct
  public void init() {
    new Thread(()->
      new NucleoMesh(
          getEnv("MESH_NAME", "mcbans"),
          getEnv("SERVICE_NAME", "watch"),
          getEnv("ZOOKEEPER", "192.168.1.7:2181"),
          getEnv("ELASTIC_HOST", "192.168.1.7"),
          Integer.valueOf(
              getEnv("ELASTIC_PORT", "9200")
          ),
          "com.nucleocore.watch.services.mesh"
      )
    ).start();
  }
}
