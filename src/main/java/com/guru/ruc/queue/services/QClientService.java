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
	
	
	public RucQueue retrieveQueue(String queueId);
	
	public List<RucQueue> listQueues();
	
//	public List<Quota> getQuota();
		
	public RucQueueMessageWithHandler consumeMessage(String queueId, String queueGroupId);
	
	public List<RucQueueMessageWithHandler> consumeMessages(String queueId, String queueGroupId, int numMessages);

	public List<RucConsumerGroup> getGroups(String queueId);

	RucActionResponse sendMessages(List<RucMessage> messages, String queueId);

	RucActionResponse sendMessage(RucMessage message, String queueId);

	RucConsumeConfirmResponse acknowledgeMessages(List<RucConsumeConfirm> consumeConfirm, String queueGroupId,
			String queueId);


}
