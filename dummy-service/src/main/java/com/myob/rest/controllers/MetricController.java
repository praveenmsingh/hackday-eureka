package com.myob.rest.controllers;


import com.myob.metrics.MetricService;
import com.myob.metrics.MetricsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MetricController {

    @Autowired
    MetricService metricService;


    @RequestMapping(value = MetricsConstants.METRIC_MAP_PATH)
    @ResponseBody
    public Map getMatric(){
        return metricService.getCurrentMatics();
    }

}
