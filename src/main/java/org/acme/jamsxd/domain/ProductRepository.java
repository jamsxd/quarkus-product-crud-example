package org.acme.jamsxd.domain;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface ProductRepository {
    
        void deleteById(String id);
    
        Multi<Product> findAll();
    
        Uni<Product> findById(String id);
    
        Uni<Void> save(Product entity);
    
}
