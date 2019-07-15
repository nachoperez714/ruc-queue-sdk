package com.guru.ruc.queue.mapper.opencloud;

import com.guru.ruc.queue.domain.RucActionResponse;
import com.huawei.openstack4j.model.common.ActionResponse;

public class ActionResponseMapper {

	private static ActionResponseMapper instance = null;
	
	private ActionResponseMapper() {}
	
	
	public static synchronized ActionResponseMapper getMapper() {
		
		if(instance == null) {
			instance = new ActionResponseMapper();
		}
		return instance;
	}
	
	
	public RucActionResponse toDomain(ActionResponse domain) {
		RucActionResponse response =  new RucActionResponse();
		response.setCode(domain.getCode());
		response.setMessage(domain.getFault());
		return response;
	}

}
