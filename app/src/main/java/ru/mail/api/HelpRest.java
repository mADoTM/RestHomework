package ru.mail.api;

import ru.mail.common.HelpContentGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Objects;

@Path("/")
public final class HelpRest {
    @GET
    public String get() {
        return HelpContentGenerator.getContent();
    }
}
