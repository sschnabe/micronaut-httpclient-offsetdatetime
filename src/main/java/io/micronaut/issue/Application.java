package io.micronaut.issue;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.convert.TypeConverter;
import io.micronaut.runtime.Micronaut;

@Factory
public class Application {

	public static void main(String[] args) {
		Micronaut.run(Application.class);
	}

	// @Singleton
	TypeConverter<String, OffsetDateTime> stringToOffset() {
		return (object, type, context) -> Optional.ofNullable(object).map(date -> {
			try {
				return OffsetDateTime.parse(date);
			} catch (DateTimeParseException e) {
				LoggerFactory.getLogger(Application.class).error("Unable to parse {}", date, e);
				return null;
			}
		});
	}

	// @Singleton
	TypeConverter<OffsetDateTime, String> offsetToString() {
		return (object, type, context) -> Optional.ofNullable(object).map(date -> date.toString());
	}
}