package com.myob.metrics;

import org.apache.catalina.connector.RequestFacade;
import org.elasticsearch.common.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.myob.metrics.MetricsConstants.*;

@Component
public class MetricFilter implements Filter {


    @Autowired
    MetricService metricService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((RequestFacade) request).getServletPath();
        if (path.contains(METRIC_MAP_PATH))
        {
            chain.doFilter(request,response);
            return;
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        chain.doFilter(request,response);
        stopWatch.stop();
        metricService.measureTime(path,stopWatch);
    }

    @Override
    public void destroy() {

    }
}
