package com.guru.ruc.queue.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RucQueue {
	private String id;
	private String name;
	private String description;
	private Integer reservation;
	private Integer maxMsgSizeByte;
	private Integer producedMessages;
	private Date created;
}
