package com.guru.ruc.queue.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guru.ruc.queue.domain.RucConsumerGroup;
import com.guru.ruc.queue.domain.RucQueue;


public class OpenCloudSdkTest extends AbstractSpringTest {

	
	private static final String  RUC_INPUT_QUEUE = "ruc-input-1";
	private static final String  RUC_OUTPUT_QUEUE = "ruc-output-1";
	
	private RucConsumerGroup consumerGroup1;
	private RucConsumerGroup consumerGroup2;
	private RucConsumerGroup consumerGroup3;
//	
	@BeforeEach
	public void createGroup() {
		consumerGroup1 = RucConsumerGroup.builder().id("g-68a542da-d6dd-473c-8c07-70c5e581d3fc").name("advertisement-edithor-adapters").build();
		consumerGroup2 = RucConsumerGroup.builder().id("g-0deebf30-cdd7-4bfd-a5e7-52fef764c497").name("advertisement-solr-adapters").build();
		consumerGroup3 = RucConsumerGroup.builder().id("g-af46348e-f73a-4f62-a62d-23951719382f").name("advertisement-csapi-adapters").build();
	}
	
	@Test
	public void testSizeListQueues() {
		assertEquals(2, getOpenCloudService().listQueues().size());
	}

	@Test
	public void testOuputQueue() {
		RucQueue rqueue = getOpenCloudService().getQueue("ab5ee216-2394-451b-a051-501aeb3f4d2c");
		assertNotNull(rqueue);
		assertEquals(RUC_OUTPUT_QUEUE, rqueue.getName());
	}
	
	@Test
	public void testInputQueue() {
		RucQueue rqueue = getOpenCloudService().getQueue("8c6245ad-9639-4fe8-83df-39327edf823d");
		assertNotNull(rqueue);
		assertEquals(RUC_INPUT_QUEUE, rqueue.getName());
	}
	
	@Test
	public void testInputConsumers() {
		List<RucConsumerGroup> groups = getOpenCloudService().getConsumersGroup("8c6245ad-9639-4fe8-83df-39327edf823d");
		assertEquals(1, groups.size());
		assertEquals("advertisement-orquestators", groups.get(0).getName());
	}
	
	@Test
	public void testOutputConsumers() {
		List<RucConsumerGroup> groups = getOpenCloudService().getConsumersGroup("ab5ee216-2394-451b-a051-501aeb3f4d2c");
		assertEquals(3, groups.size());
		assertThat(groups, anyOf(hasItem(consumerGroup1), hasItem(consumerGroup2), hasItem(consumerGroup3)));

	}

	
	
	

}
