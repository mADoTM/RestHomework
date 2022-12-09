package ru.mail.api;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import ru.mail.dao.DataService;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
public class CompanyRest {
    private final @NotNull DataService service;

    @Inject
    public CompanyRest(@NotNull DataService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("company_name") String companyName) {
        try {
            return Response.ok(service.getAllProductOfCompany(companyName))
                    .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                    .header("injected", "true")
                    .build();
        } catch (IllegalStateException e) {
            return Response
                    .status(404)
                    .build();
        }
    }

    @POST
    public Response post(@QueryParam("product_name") String productName,
                         @QueryParam("company_name") String companyName,
                         @QueryParam("count") int count) {
        service.add(productName, companyName, count);
        return Response.ok().build();
    }
}
