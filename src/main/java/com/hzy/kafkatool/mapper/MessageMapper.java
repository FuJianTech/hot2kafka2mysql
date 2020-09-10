package com.hzy.kafkatool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzy.kafkatool.entity.HotMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper  extends BaseMapper<HotMessage> {
   // int insert(HotMessage msg);


}
