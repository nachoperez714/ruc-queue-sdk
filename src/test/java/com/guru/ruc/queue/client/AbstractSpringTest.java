package com.guru.ruc.queue.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.guru.ruc.queue.services.impl.OpenCloudService;

@ExtendWith(MockitoExtension.class)
public class AbstractSpringTest {

	private OpenCloudService openCloudService;

	@BeforeEach
	void setUp() {
		this.openCloudService = new OpenCloudService();
	}

	public OpenCloudService getOpenCloudService() {
		return openCloudService;
	}

}
