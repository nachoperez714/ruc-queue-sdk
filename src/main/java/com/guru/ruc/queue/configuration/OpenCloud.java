package com.guru.ruc.queue.configuration;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OpenCloud {
	private String ak;
	private String sk;
	private String projectId;
	private String region;
	private String domain;
	public Integer queueTimeOut;
}
