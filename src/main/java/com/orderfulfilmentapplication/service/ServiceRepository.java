package com.orderfulfilmentapplication.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Repository
public class ServiceRepository {

	@Autowired
	RestTemplate restTemplate;


	public Object getFromExternalService(BigInteger bigInteger) {
		return bigInteger;
	}

	private static int COUNTER = 0;

	@Retryable(value = { Exception.class }, maxAttempts = 4, backoff = @Backoff(2000))
	public Object callingExternalService() throws Exception {
		// in acutal case here your code will call for db hit or 3rd party
		// http api call etc
		COUNTER++;
		System.out.println("COUNTER = " + COUNTER);
		throw new Exception("Forcefully Exception ");
	}

	@Recover // this method will call after all attempt is getting over
	public String recover(Throwable t) {
		System.out.println("Recover method called after all retry attempt and still getting error");
		return "Error Class :: " + t.getClass().getName();
	}

	@CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
	public String getRandomActivity() {
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("/serviceAPI", Object.class);
		Object activity = responseEntity.getBody();
		return activity.toString();
	}

	public String fallbackRandomActivity(Throwable throwable) {
		return "Inside fall back";
	}

}
