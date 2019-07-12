package com.guru.ruc.queue.configuration;

import com.huawei.openstack4j.api.OSClient.OSClientAKSK;
import com.huawei.openstack4j.core.transport.Config;
import com.huawei.openstack4j.openstack.OSFactory;

public class OpenCloudConfig {

	private ApplicationProperties applicationProperties = ApplicationProperties.get();
	private static OpenCloudConfig instance = null;

	private OpenCloudConfig() {}

	public static OpenCloudConfig get() {
		if (instance == null) {
			synchronized (OpenCloudConfig.class) {
				if (instance == null) {
					instance = new OpenCloudConfig();
				}
			}
		}
		return instance;
	}

	public OSClientAKSK getOSClient() {
		setEnableHttpLoggingFilter();
		return OSFactory.builderAKSK().withConfig(setConfig()).credentials(
				applicationProperties.getOpenCloud().getAk(),
				applicationProperties.getOpenCloud().getSk(), 
				applicationProperties.getOpenCloud().getRegion(),
				applicationProperties.getOpenCloud().getProjectId(), 
				applicationProperties.getOpenCloud().getDomain()).authenticate();
	}

	private Config setConfig() {
		return Config.newConfig().withSSLVerificationDisabled();
	}

	private void setEnableHttpLoggingFilter() {
		OSFactory.enableHttpLoggingFilter(true);
	}

}
