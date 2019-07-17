package com.guru.ruc.queue.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class RucConsumerGroup {
	
	private String id;
	private String name;
	@EqualsAndHashCode.Exclude
	private Integer producedMessages;
	@EqualsAndHashCode.Exclude
	private Integer consumedMessages;
	@EqualsAndHashCode.Exclude
	private Integer availableMessages;
}
