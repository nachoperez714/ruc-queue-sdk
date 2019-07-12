package com.guru.ruc.queue.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guru.ruc.queue.domain.RucQueue;
import com.guru.ruc.queue.mapper.opencloud.QueueMapper;
import com.guru.ruc.queue.services.impl.OpenCloudService;
import com.huawei.openstack4j.openstack.message.queue.domain.Queue;

public class OpenCloudSdkTest extends AbstractSpringTest {

	@Autowired
	private OpenCloudService openCloudService;

	private Queue queue;
	private RucQueue queDto;

	@BeforeEach
	public void init() {
//		queue = Queue.builder().id("ruc-input-1").build();
//		queDto = QueueMapper.INSTANCE.toDomain(queue);
	}

	@Test
	public void testCreatedQueue() {
		Assertions.assertEquals(2, openCloudService.listQueues().size());
	}

//	@Test
//	public void testQueue() {
//		Assertions.assertEquals(queDto.getId(), openCloudService.retrieveQueue("ruc-input-1"));
//	}

}
