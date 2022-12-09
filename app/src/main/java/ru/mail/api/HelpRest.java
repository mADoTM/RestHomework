package ru.mail.api;

import ru.mail.common.HelpContentGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public final class HelpRest {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Object get() {
        return HelpContentGenerator.getContent();
    }
}
