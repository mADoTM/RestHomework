package ru.mail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class Company {
    @JsonProperty("id")
    public final int id;

    @JsonProperty("name")
    public final @NotNull String name;

    @JsonCreator
    public Company(@JsonProperty("id") int id,
                   @JsonProperty("name") @NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
