package ru.mail.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.NotNull;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public final class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
    private final @NotNull ObjectMapper defaultObjectMapper;

    public ObjectMapperProvider() {
        final var result = new ObjectMapper();
        result.configure(SerializationFeature.INDENT_OUTPUT, true);
        defaultObjectMapper = result;
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }
}
