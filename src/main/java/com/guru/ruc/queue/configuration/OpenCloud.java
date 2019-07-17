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
//	public QueueConfig queueConfig;

//	@Data
//	@Builder
//	public static class QueueConfig {
//		private Queue input;
//		private Queue ouput;
//
//		@Builder
//		@Data
//		public static class Queue {
//			private String name;
//			private String id;
//			private List<Consumer> consumers;
//
//			@Builder
//			@Data
//			public static class Consumer {
//				private String name;
//				private String id;
//			}
//
//		}
//
//	}

}
