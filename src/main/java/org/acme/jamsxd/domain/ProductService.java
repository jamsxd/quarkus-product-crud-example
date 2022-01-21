package org.acme.jamsxd.domain;

import org.acme.jamsxd.infrastructure.persistence.MongoRepository;
import org.springframework.stereotype.Service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;


@Service
public class ProductService implements DomainService {
    
    private final MongoRepository repository;

    public ProductService(MongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uni<Product> getProduct(String sku) {
        return repository.findById(sku);
    }

    @Override
    public Multi<Product> getProducts() {
        return this.repository.findAll();
    }

    @Override
    public Uni<Product> saveProduct(Product product) {;
        return this.repository.save(product).map(mapper -> product);
    }

    @Override
    public Uni<Void> deleteProduct(String sku) {
        repository.deleteById(sku);
        return Uni.createFrom().voidItem();
    }
}
