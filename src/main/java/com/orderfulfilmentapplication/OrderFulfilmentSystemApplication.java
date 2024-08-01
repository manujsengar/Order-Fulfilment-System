package com.orderfulfilmentapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.*;
import java.util.concurrent.Callable;

@SpringBootApplication
@EnableCaching
//@EnableScheduling
@EnableAsync
@EnableJpaRepositories
@EnableRetry
public class OrderFulfilmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFulfilmentSystemApplication.class, args);

		List<Integer> list = new ArrayList<>();

		list.stream().forEach(() -> 
		});
	}

}
