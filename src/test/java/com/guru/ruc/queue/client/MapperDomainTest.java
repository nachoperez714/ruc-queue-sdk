package com.guru.ruc.queue.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.guru.ruc.queue.domain.RucMessage;
import com.guru.ruc.queue.mapper.opencloud.MessageMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessage;

public class MapperDomainTest extends AbstractSpringTest {

	@Test
	public void shouldMapQueueMessageToDto() {
		QueueMessage entity = QueueMessage.builder().body("test").build();
		RucMessage message = MessageMapper.INSTANCE.toDomain(entity);
	    Assertions.assertEquals(message.getBody(), entity.getBody());

	}
}
