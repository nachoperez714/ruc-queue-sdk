package com.guru.ruc.queue.domain;

import lombok.Data;

@Data
public class RucConsumerGroup {
	private String id;
	private String name;
	private Integer producedMessages;
	private Integer consumedMessages;
	private Integer availableMessages;
}
