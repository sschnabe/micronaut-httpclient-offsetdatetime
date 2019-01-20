package io.micronaut.issue;

import java.net.URI;
import java.time.OffsetDateTime;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class TimeControllerTest {

	@Inject
	TimeClient declarativeClient;
	@Inject
	@Client("/")
	RxHttpClient httpClient;

	@Test
	@DisplayName("Declarative client with OffsetDateTime")
	void declarative() {
		OffsetDateTime time = OffsetDateTime.now();
		Assertions.assertEquals(time, declarativeClient.time(time));
	}

	@Test
	@DisplayName("Http client with OffsetDateTime")
	void http() throws JsonProcessingException {
		OffsetDateTime time = OffsetDateTime.now();
		URI uri = UriBuilder.of("/offset").queryParam("time", time).build();
		Assertions.assertEquals(time, httpClient.retrieve(HttpRequest.GET(uri), OffsetDateTime.class).blockingFirst());
	}
}