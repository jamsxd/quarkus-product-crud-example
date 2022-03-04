package org.acme.jamsxd.domain;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface DomainService {
   Uni<Product> getProduct(String sku);
   Multi<Product> getProducts();
   Uni<Product> saveProduct(Product product) throws Exception;
   Uni<Void> deleteProduct(String sku);
}
