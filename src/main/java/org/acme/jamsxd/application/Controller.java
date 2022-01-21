package org.acme.jamsxd.application;


import org.acme.jamsxd.domain.Product;
import org.acme.jamsxd.domain.ProductService;
import org.springframework.web.bind.annotation.RestController;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@RestController
public class Controller implements Api {
    
    private final ProductService service;

    public Controller(ProductService service) {
        this.service = service;
    }

    @Override
    public Uni<Product> get(String sku) {
        return service.getProduct(sku);
    }

    @Override
    public Multi<Product> getAll() {
        return service.getProducts();
    }

    @Override
    public Uni<Product> create(Product product) {
        return service.saveProduct(product);
    }

    @Override
    public Uni<Void> delete(String sku) {
        return service.deleteProduct(sku);
    }
}
