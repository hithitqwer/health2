package com.creator;

import com.creator.mapper.BodyOverallMapper;
import com.creator.model.BodyOverallPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhangzeyu
 */
@Service
public class BodyServiceImp implements BodyService {

    @Autowired
    private BodyOverallMapper bodyOverallMapper;

    @Override
    public int count() {
        return bodyOverallMapper.count();
    }

    @Override
    public BodyOverallPO selectByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        return bodyOverallMapper.selectByCode(code);
    }

    @Override
    public void write(BodyOverallPO bodyOverallPO) {
        if(Objects.isNull(bodyOverallPO) || Objects.isNull(bodyOverallPO.getCode())) {
            return;
        }
        if(Objects.isNull(selectByCode(bodyOverallPO.getCode()))) {
            bodyOverallMapper.insert(bodyOverallPO);
        }else {
            bodyOverallMapper.update(bodyOverallPO);
        }
    }

    @Override
    public void delete(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code))) {
            return;
        }
        bodyOverallMapper.deleteByCode(code);
    }

}
