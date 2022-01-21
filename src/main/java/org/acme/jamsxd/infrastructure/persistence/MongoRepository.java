package org.acme.jamsxd.infrastructure.persistence;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import org.acme.jamsxd.domain.Product;
import org.acme.jamsxd.domain.ProductRepository;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Repository
public class MongoRepository implements ProductRepository {

    private final ReactiveMongoClient client;

    public MongoRepository(ReactiveMongoClient client) {
        this.client = client;
    }

    @Override
    public void deleteById(String id) {
        getCollection().deleteOne(Filters.eq("sku", id)).subscribeAsCompletionStage();
    }

    @Override
    public Multi<Product> findAll() {
        return getCollection().find();
    }

    @Override
    public Uni<Product> findById(String id) {
        return getCollection().find(Filters.eq("sku", id)).toUni();
    }

    @Override
    public Uni<Void> save(Product entity) {
        return getCollection()
            .findOneAndReplace(new Document("sku", entity.getSku()), entity, new FindOneAndReplaceOptions().upsert(true))
            .onItem().ignore().andContinueWithNull();
    }

    private ReactiveMongoCollection<Product> getCollection() {
        return this.client.getDatabase("admin").getCollection("products", Product.class);
    }

}
