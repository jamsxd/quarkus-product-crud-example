package org.acme.jamsxd.application;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.acme.jamsxd.domain.Product;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/products")
public interface Api {

    @POST
    Uni<Product> create(Product entity) throws Exception;

    @GET
    Multi<Product> getAll();

    @Path("/{id}")
    @GET
    Uni<Product> get(String id);

    @Path("/{id}")
    @DELETE
    Uni<Void> delete(String id);
    
}
