package com.myob.metrics;


import com.netflix.util.Pair;
import org.elasticsearch.common.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.repository.MetricRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MetricService {

    private ConcurrentMap<String,ConcurrentMap<Long,  Long>> timeMap = new ConcurrentHashMap<>();




    public void measureTime(String path , StopWatch stopWatch)
    {
        if (!timeMap.containsKey(path))
        {
            timeMap.put(path,new ConcurrentHashMap<>());
        }
        Map pathMetrics = timeMap.get(path);
        pathMetrics.put(System.currentTimeMillis(),  stopWatch.totalTime().getMillis());
    }

    public Map getCurrentMatics() {
        return timeMap;
    }

    //  @Scheduled(fixedDelay = 1000)
  //  private void exportMetrics(){
  //      Metric<?> metric;

 //   }

}
