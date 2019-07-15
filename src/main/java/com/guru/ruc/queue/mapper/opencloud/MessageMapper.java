package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucMessage;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessage;

@Mapper
public interface MessageMapper extends EntityMapper<RucMessage, QueueMessage> {
	 MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
}
