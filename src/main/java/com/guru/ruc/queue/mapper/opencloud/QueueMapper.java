package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucQueue;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.Queue;

@Mapper
public interface QueueMapper extends EntityMapper<RucQueue, Queue> {

	QueueMapper INSTANCE = Mappers.getMapper(QueueMapper.class);

}
