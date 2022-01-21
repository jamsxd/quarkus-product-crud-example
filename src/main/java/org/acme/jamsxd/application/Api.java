package org.acme.jamsxd.application;

import org.acme.jamsxd.domain.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/products")
public interface Api {

    @GetMapping
    Multi<Product> getAll();

    @PostMapping
    Uni<Product> create(@RequestBody Product entity);

    @GetMapping("/{id}")
    Uni<Product> get(String id);

    @DeleteMapping("/{id}")
    Uni<Void> delete(String id);
    
}
