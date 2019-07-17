package com.guru.ruc.queue.client;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guru.ruc.queue.domain.RucMessage;
import com.guru.ruc.queue.mapper.opencloud.MessageMapper;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessage;

public class MapperDomainTest extends AbstractSpringTest {

	private QueueMessage message;
	
	@BeforeEach
	public void buildMessage() {
		HashMap<String, Object> attributes = new HashMap<>();
		attributes.put("client", "input-adapter");
		attributes.put("date", new Date());
		String msg = "{\"aviso\":2222, name:\"test\"}";
		message = QueueMessage.builder().body(msg).attributes(attributes).build();

	}
	
	@Test
	public void shouldMapQueueMessageToRucDomain() {
		RucMessage message = MessageMapper.INSTANCE.toDomain(this.message);
	    Assertions.assertEquals(message.getBody(), this.message.getBody());

	}
}
