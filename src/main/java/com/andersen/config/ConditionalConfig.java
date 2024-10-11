package com.andersen.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConditionalConfig {

	@Bean
	@ConditionalOnProperty(name = "app.enable.feature", havingValue = "true")
	public String featureEnabled() {
		log.info("Feature is enabled");
		return "Feature is enabled";
	}

	@Bean
	@ConditionalOnProperty(name = "app.enable.feature", havingValue = "false", matchIfMissing = true)
	public String featureDisabled() {
		log.info("Feature is disabled");
		return "Feature is disabled";
	}

}
