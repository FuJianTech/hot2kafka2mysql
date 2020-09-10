package com.hzy.kafkatool.service;

import com.hzy.kafkatool.entity.HotMessage;
import com.hzy.kafkatool.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    @Autowired
    private MessageMapper msgMapper;

    public int install(HotMessage hotMessage){

        return msgMapper.insert(hotMessage);
    }
}

