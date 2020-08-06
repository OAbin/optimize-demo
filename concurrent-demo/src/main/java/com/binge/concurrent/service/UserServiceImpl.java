package com.binge.concurrent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;

@Service
public class UserServiceImpl {

    @Autowired
    private RemoteServiceImpl remoteService;


    private LinkedBlockingQueue<Request> queue;

    public Map<String, String> userById(String id) throws ExecutionException, InterruptedException {
        Request request = new Request();
        request.id = id;
        request.serialNo = UUID.randomUUID().toString();
        request.future = new CompletableFuture<>();

        queue.add(request);

        return request.future.get();
        //return remoteService.userById(id);
    }


    @PostConstruct
    void init(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int size = queue.size();
                if (size == 0){
                    return;
                }
                List<Request> requests = new ArrayList<>();
                List<Map<String, String>> params = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    Request request = queue.poll();
                    Map map = new HashMap();
                    map.put("id", request.id);
                    map.put("serialNo", request.serialNo);
                    params.add(map);

                    requests.add(request);
                }
                List<Map<String, String>> responses  = remoteService.usersByIds(params);
                for (Request request: requests){
                    if (request.serialNo.equals("")){

                    }
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }


    class Request{
        String id;
        String serialNo;
        CompletableFuture<Map<String, String>> future;
    }
}
