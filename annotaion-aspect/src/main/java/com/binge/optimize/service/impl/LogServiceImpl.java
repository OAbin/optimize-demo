package com.binge.optimize.service.impl;

import com.binge.optimize.domain.Log;
import com.binge.optimize.service.LogService;
import org.springframework.stereotype.Service;


@Service
public class LogServiceImpl implements LogService {

    @Override
    public void addLog(Log log) {
        System.out.println("日志记录服务");
    }
}
