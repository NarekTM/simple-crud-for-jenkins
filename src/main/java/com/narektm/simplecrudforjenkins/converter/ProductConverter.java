package com.narektm.simplecrudforjenkins.converter;

import com.narektm.simplecrudforjenkins.dto.ProductDto;
import com.narektm.simplecrudforjenkins.entity.Product;
import com.narektm.simplecrudforjenkins.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product toEntity(ProductModel model) {
        Product product = new Product();

        product.setName(model.name());
        product.setDescription(model.description());

        return product;
    }

    public ProductDto toDto(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getDescription());
    }
}
