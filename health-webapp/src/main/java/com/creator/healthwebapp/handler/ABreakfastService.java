package com.creator.healthwebapp.handler;

import com.creator.healthwebapp.vo.afood.ABreakfast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ABreakfastService implements AFoodService{

    private Logger logger = LoggerFactory.getLogger(ABreakfast.class);

    @Override
    public void write() {
        logger.info("456");
    }
}
