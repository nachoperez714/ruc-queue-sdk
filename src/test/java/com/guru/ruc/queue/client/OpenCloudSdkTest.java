package com.guru.ruc.queue.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.guru.ruc.queue.domain.RucQueue;

public class OpenCloudSdkTest extends AbstractSpringTest {

	@Test
	public void testCreatedQueue() {
		Assertions.assertEquals(2, getOpenCloudService().listQueues().size());
	}

	@Test
	public void testQueue() {
		RucQueue rqueue = getOpenCloudService().retrieveQueue("8c6245ad-9639-4fe8-83df-39327edf823d");
		Assertions.assertNotNull(rqueue);
		Assertions.assertEquals("ruc-input-1", rqueue.getName());
	}

}
