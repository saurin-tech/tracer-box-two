package com.example.tracerboxtwo.controller;

import com.example.tracerboxtwo.service.TracerBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TracerBoxController {

    @Autowired
    public TracerBoxService tracerBoxService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello from Tracer Box Two!";
    }

    @RequestMapping(value = "/decision", method = RequestMethod.GET)
    public String makeDecision(){
        Random rand = new Random();

        int  n = rand.nextInt(2) + 1;

//        if(n == 1){
//            new Thread(()-> {
//                tracerBoxService.start();
//            }).start();
//            return "forwarded";
//        }
//        else {
//            System.out.println("not forwarded");
//            return "not forwarded";
//        }

        if(n ==1){
           return tracerBoxService.start();
        }else {
            System.out.println("not forwarded");
            return "not forwarded";
        }
    }
}
