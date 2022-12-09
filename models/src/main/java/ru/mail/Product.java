package ru.mail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class Product {
    @JsonProperty("id")
    public final int id;

    @JsonProperty("name")
    public final @NotNull String name;

    @JsonProperty("companyId")
    public final int companyId;

    @JsonProperty("count")
    public final int count;

    @JsonCreator
    public Product(@JsonProperty("id") int id,
                   @JsonProperty("name") @NotNull String name,
                   @JsonProperty("companyId") int companyId,
                   @JsonProperty("count") int count) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
        this.count = count;
    }
}
