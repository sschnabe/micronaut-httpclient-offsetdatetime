package io.micronaut.issue;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

public interface TimeApi {

	@Get(uri = "/offset", produces = MediaType.APPLICATION_JSON)
	OffsetDateTime time(@NotNull @QueryValue OffsetDateTime time);
}