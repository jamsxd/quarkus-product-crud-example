package org.acme.jamsxd.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String sku;
    private String name;
    private String brand;
    private String size;
    private Double price;
    private String principalImage;
    private List<String> otherImages;
}
