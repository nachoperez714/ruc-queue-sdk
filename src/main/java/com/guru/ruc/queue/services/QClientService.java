package com.guru.ruc.queue.services;

import java.util.List;

import com.guru.ruc.queue.domain.RucActionResponse;
import com.guru.ruc.queue.domain.RucConsumeConfirm;
import com.guru.ruc.queue.domain.RucConsumeConfirmResponse;
import com.guru.ruc.queue.domain.RucConsumerGroup;
import com.guru.ruc.queue.domain.RucMessage;
import com.guru.ruc.queue.domain.RucQueue;
import com.guru.ruc.queue.domain.RucQueueMessageWithHandler;

public interface QClientService {

	RucQueue getQueue(String queueId);

	List<RucQueue> listQueues();

//	public List<Quota> getQuota();

	RucQueueMessageWithHandler consumeMessage(String queueId, String queueGroupId);

	List<RucQueueMessageWithHandler> consumeMessages(String queueId, String queueGroupId, int numMessages);

	List<RucConsumerGroup> getConsumersGroup(String queueId);

	RucActionResponse sendMessages(List<RucMessage> messages, String queueId);

	RucActionResponse sendMessage(RucMessage message, String queueId);

	RucConsumeConfirmResponse acknowledgeMessages(List<RucConsumeConfirm> consumeConfirm, String queueGroupId,
			String queueId);

}
