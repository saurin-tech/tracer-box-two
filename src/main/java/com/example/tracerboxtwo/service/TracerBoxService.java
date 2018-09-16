package com.example.tracerboxtwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TracerBoxService {

    @Value("${restURL}")
    public String restURL;

    @Autowired
    public RestTemplate restTemplate;

    public TracerBoxService() { }

    public String start() {
        String restReply = restTemplate.getForObject(restURL, String.class);
        System.out.println("Last Reply: " + restReply);
        System.out.println("start method of the second tracer box done");
        return restReply;
    }
}
