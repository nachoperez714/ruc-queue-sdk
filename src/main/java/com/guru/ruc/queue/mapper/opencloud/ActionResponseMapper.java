package com.guru.ruc.queue.mapper.opencloud;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.guru.ruc.queue.domain.RucActionResponse;
import com.guru.ruc.queue.mapper.EntityMapper;
import com.huawei.openstack4j.model.common.ActionResponse;

@Mapper
public interface ActionResponseMapper extends EntityMapper<RucActionResponse, ActionResponse> {

	ActionResponseMapper INSTANCE = Mappers.getMapper(ActionResponseMapper.class);

}
