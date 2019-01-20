package io.micronaut.issue;

import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface TimeClient extends TimeApi {}