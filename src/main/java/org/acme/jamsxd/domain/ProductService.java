package org.acme.jamsxd.domain;

import javax.enterprise.context.ApplicationScoped;

import org.acme.jamsxd.infrastructure.persistence.MongoRepository;
import org.eclipse.microprofile.opentracing.Traced;
import org.jboss.logging.Logger;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Traced
@ApplicationScoped
public class ProductService implements DomainService {

    private static final Logger LOG = Logger.getLogger(ProductService.class);
    
    private final MongoRepository repository;

    public ProductService(MongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uni<Product> getProduct(String sku) {
        LOG.info("getProduct(" + sku + ")");
        return repository.findById(sku);
    }

    @Override
    public Multi<Product> getProducts() {
        LOG.info("getProducts()");
        return this.repository.findAll();
    }

    @Override
    public Uni<Product> saveProduct(Product product) throws Exception {;
        LOG.info("saveProduct(" + product + ")");
        if (product.getSku() == null) {
            throw new Exception();
        }
        return this.repository.save(product).map(mapper -> product);
    }

    @Override
    public Uni<Void> deleteProduct(String sku) {
        LOG.info("deleteProduct(" + sku + ")");
        repository.deleteById(sku);
        return Uni.createFrom().voidItem();
    }
}
