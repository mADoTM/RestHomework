package ru.mail.api;


import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import ru.mail.Product;
import ru.mail.dao.DataService;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("/product")
public final class ProductRest {
    private final DataService service;

    @Inject
    public ProductRest(@NotNull DataService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        final var result = new HashMap<String, List<Product>>();

        service.getAllCompaniesWithProducts()
                .forEach((company, products) ->  result.put(company.name, products));

        return Response.ok(result)
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .header("injected", "true")
                .build();
    }

    @POST
    public Response post(@QueryParam("product_name") String productName) {
        try {
            var product = service.getProductByName(productName);
            service.deleteProductById(product.id);
            return Response.ok().build();
        } catch (IllegalStateException e) {
            return Response.status(404).build();
        }
    }
}
