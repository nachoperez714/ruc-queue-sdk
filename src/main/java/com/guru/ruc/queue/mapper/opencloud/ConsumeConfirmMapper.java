package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucConsumeConfirmResponse;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.ConsumeConfirmResponse;

@Mapper
public interface ConsumeConfirmMapper extends EntityMapper<RucConsumeConfirmResponse, ConsumeConfirmResponse> {

	ConsumeConfirmMapper INSTANCE = Mappers.getMapper(ConsumeConfirmMapper.class);

}
