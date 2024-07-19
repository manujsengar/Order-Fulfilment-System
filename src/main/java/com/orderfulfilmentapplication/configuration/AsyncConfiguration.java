package com.orderfulfilmentapplication.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

	@Bean("asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(4);
		taskExecutor.setQueueCapacity(150);
		taskExecutor.setMaxPoolSize(4);
		taskExecutor.setThreadNamePrefix("AsyncTaskThread-");
		taskExecutor.initialize();
		;
		return taskExecutor;
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(300000)).setReadTimeout(Duration.ofMillis(300000)).build();
	}

}
