package com.guru.ruc.queue.services.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.guru.ruc.queue.configuration.ApplicationProperties;
import com.guru.ruc.queue.configuration.OpenCloudConfig;
import com.guru.ruc.queue.domain.RucActionResponse;
import com.guru.ruc.queue.domain.RucConsumeConfirm;
import com.guru.ruc.queue.domain.RucConsumeConfirmResponse;
import com.guru.ruc.queue.domain.RucConsumerGroup;
import com.guru.ruc.queue.domain.RucMessage;
import com.guru.ruc.queue.domain.RucQueue;
import com.guru.ruc.queue.domain.RucQueueMessageWithHandler;
import com.guru.ruc.queue.mapper.opencloud.ActionResponseMapper;
import com.guru.ruc.queue.mapper.opencloud.ConsumeConfirmMapper;
import com.guru.ruc.queue.mapper.opencloud.ConsumerGroupMapper;
import com.guru.ruc.queue.mapper.opencloud.MessageMapper;
import com.guru.ruc.queue.mapper.opencloud.MessageWithHandlerMapper;
import com.guru.ruc.queue.mapper.opencloud.QueueMapper;
import com.guru.ruc.queue.services.QClientService;
import com.huawei.openstack4j.api.OSClient.OSClientAKSK;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.openstack.message.queue.constant.ConsumeStatus;
import com.huawei.openstack4j.openstack.message.queue.domain.Queue;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessage;
import com.huawei.openstack4j.openstack.message.queue.domain.QueueMessageWithHandler;

/**
 * Implementation para manejar colas DMS de open cloud
 */

public class OpenCloudService implements QClientService {

//	private static final Logger LOGGER = LoggerFactory.getLogger(OpenCloudService.class);

	private final OSClientAKSK client = OpenCloudConfig.get().getOSClient();
	private final ApplicationProperties applicationProperties = ApplicationProperties.get();
	
	private  MessageMapper messageMapper = MessageMapper.INSTANCE;
	private final QueueMapper queueMapper = QueueMapper.INSTANCE;
	private final MessageWithHandlerMapper messageWithHandlerMapper = MessageWithHandlerMapper.INSTANCE;
	private final ConsumerGroupMapper consumerGroupMapper = ConsumerGroupMapper.INSTANCE;
	private final ConsumeConfirmMapper consumeConfirmMapper = ConsumeConfirmMapper.INSTANCE;
	private final ActionResponseMapper actionResponseMapper = ActionResponseMapper.INSTANCE;	

	@Override
	public RucQueue retrieveQueue(String queueId) {
		Queue queue = client.messageQueue().queue().get(queueId);
		return queueMapper.toDomain(queue);
	}

	@Override
	public List<RucQueue> listQueues() {
		List<? extends Queue> list = client.messageQueue().queue().list();
		return queueMapper.toDomain(list);
	}

	@Override
	public RucActionResponse sendMessages(List<RucMessage> messages, String queueId) {
		List<QueueMessage> queueMessages = messageMapper.toEntity(messages);
		ActionResponse response = client.messageQueue().messages().produce(queueId, queueMessages);
		return actionResponseMapper.toDomain(response);
	}

	@Override
	public RucActionResponse sendMessage(RucMessage message, String queueId) {
		QueueMessage queueMessage = messageMapper.toEntity(message);
		ActionResponse response = client.messageQueue().messages().produce(queueId, queueMessage);
		return actionResponseMapper.toDomain(response);	
	}

	@Override
	public RucQueueMessageWithHandler consumeMessage(String queueId, String queueGroupId) {
		List<QueueMessageWithHandler> list = client.messageQueue().messages().consume(queueId, queueGroupId, 1, applicationProperties.getOpenCloud().getQueueTimeOut());
		return messageWithHandlerMapper.toDomain(list).get(0);

	}

	@Override
	public List<RucQueueMessageWithHandler> consumeMessages(String queueId, String queueGroupId, int numMessages) {
		List<QueueMessageWithHandler> list = client.messageQueue().messages().consume(queueId, queueGroupId, numMessages,  applicationProperties.getOpenCloud().getQueueTimeOut());
		return messageWithHandlerMapper.toDomain(list);
	}

	@Override
	public RucConsumeConfirmResponse acknowledgeMessages(List<RucConsumeConfirm> consumeConfirm, String queueGroupId, String queueId) {
		Map<String, ConsumeStatus> handlerMap = consumeConfirm.stream() .collect(Collectors.toMap(x -> x.getHandler(), x -> x.getStatus()));
		return consumeConfirmMapper.toDomain(client.messageQueue().messages().confirmConsuming(queueId, queueGroupId,  handlerMap));
	}

	@Override
	public List<RucConsumerGroup> getGroups(String queueId) {
		return consumerGroupMapper.toDomain(client.messageQueue().consumerGroups().list(queueId));
	}

}
