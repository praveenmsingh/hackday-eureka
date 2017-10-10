package com.myob.rest.controllers;


import com.netflix.spectator.api.Registry;
import com.netflix.spectator.api.Timer;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ActuatorMetricWriter;
import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.reader.MetricReader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SysexMessage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


@RestController
public class HelloController {

    static final int SECOND_IN_MS = 1000;

    @RequestMapping("metric-mocker")
    public String metricMocker() throws InterruptedException {
        long timeToWait = ThreadLocalRandom.current().nextInt(0, 15 );

        Thread.sleep(timeToWait * SECOND_IN_MS);

        return "you waited just for me about ~" + timeToWait +" seconds";
    }


}

