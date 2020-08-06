package com.binge.concurrent;


import com.binge.concurrent.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class ConcurrentApplicationTests {

    private static int MAX_SIZE = 1000;

    CountDownLatch downLatch = new CountDownLatch(MAX_SIZE);

    @Autowired
    private UserServiceImpl userService;

    @Test public void testConcurrent(){
        for (int i = 0;i < MAX_SIZE; i++){
            new Thread(()->{
                downLatch.countDown();
                try {
                    downLatch.await();
                    Map<String, String> map = userService.userById("");
                    System.out.println(map);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
