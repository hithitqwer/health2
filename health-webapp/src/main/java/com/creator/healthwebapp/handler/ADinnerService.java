package com.creator.healthwebapp.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ADinnerService implements AFoodService {

    private Logger logger = LoggerFactory.getLogger(ADinnerService.class);

    @Override
    public void write() {
        logger.info("123");
    }
}
