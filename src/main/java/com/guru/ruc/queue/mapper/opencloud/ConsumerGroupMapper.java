package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucConsumerGroup;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.ConsumerGroup;

@Mapper
public interface ConsumerGroupMapper extends EntityMapper<RucConsumerGroup, ConsumerGroup> {

	ConsumerGroupMapper INSTANCE = Mappers.getMapper(ConsumerGroupMapper.class);

}
