package com.guru.ruc.queue.configuration;

import java.net.URL;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guru.ruc.queue.errors.ConfigException;

public class ApplicationProperties extends PropertiesConfiguration {

	private static ApplicationProperties instance = null;
	public static final String APPLICATION_PROPERTIES = "configuration.properties";
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

	private ApplicationProperties(URL url) throws ConfigurationException {
		super(url);
		getOpenCloudConfig();
	}

	public static ApplicationProperties get() {
		if (instance == null) {
			synchronized (ApplicationProperties.class) {
				if (instance == null) {
					try {
						instance = newConfig(APPLICATION_PROPERTIES);
					} catch (ConfigException e) {
						LOGGER.error("Failed to get instance", e);
					}
				}
			}
		}
		return instance;
	}
	
	

	private static ApplicationProperties newConfig(String fileName) throws ConfigException {
		try {
			LOGGER.info("Looking for {} in classpath", fileName);
			URL url = ApplicationProperties.class.getClassLoader().getResource(fileName);
			LOGGER.info("Loading {} from {}", fileName, url);
			ApplicationProperties appProperties = new ApplicationProperties(url);
			Configuration configuration = appProperties.interpolatedConfiguration();
			logConfiguration(configuration);
			return appProperties;
		} catch (ConfigurationException e) {
			throw new ConfigException("Failed to load application properties", e);
		}
	}

	private static void logConfiguration(Configuration configuration) {
		if (LOGGER.isDebugEnabled()) {
			Iterator<String> keys = configuration.getKeys();
			LOGGER.debug("Configuration loaded:");
			while (keys.hasNext()) {
				String key = keys.next();
				LOGGER.debug("{} = {}", key, configuration.getProperty(key));
			}
		}
	}

	private final OpenCloud openCloud = getOpenCloudConfig();

	private OpenCloud getOpenCloudConfig() {
		return OpenCloud.builder()
				.ak(getString("opencloud.credentials.ak"))
				.sk(getString("opencloud.credentials.sk"))
				.projectId(getString("opencloud.credentials.project-id"))
				.region(getString("opencloud.credentials.region"))
				.domain(getString("opencloud.credentials.domain"))
				.build();
	}



	public OpenCloud getOpenCloud() {
		return openCloud;
	}

}
