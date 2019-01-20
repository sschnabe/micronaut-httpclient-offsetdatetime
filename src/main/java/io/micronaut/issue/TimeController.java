package io.micronaut.issue;

import java.time.OffsetDateTime;

import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;

@Validated
@Controller
public class TimeController implements TimeApi {

	@Override
	public OffsetDateTime time(OffsetDateTime time) {
		return time;
	}
}