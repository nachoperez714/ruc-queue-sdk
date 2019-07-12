package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucQueueMessageWithHandler;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessageWithHandler;

@Mapper
public interface MessageWithHandlerMapper extends EntityMapper<RucQueueMessageWithHandler, QueueMessageWithHandler>
{
	MessageWithHandlerMapper INSTANCE = Mappers.getMapper(MessageWithHandlerMapper.class); 
}
