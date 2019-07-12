package com.guru.ruc.queue.errors;

import org.apache.commons.configuration.ConfigurationException;

public class ConfigException extends Exception{

	public ConfigException(String msg, ConfigurationException e) {
		super(msg, e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
