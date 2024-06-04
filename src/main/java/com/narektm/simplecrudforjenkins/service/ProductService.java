package com.narektm.simplecrudforjenkins.service;

import com.narektm.simplecrudforjenkins.converter.ProductConverter;
import com.narektm.simplecrudforjenkins.dto.ProductDto;
import com.narektm.simplecrudforjenkins.entity.Product;
import com.narektm.simplecrudforjenkins.model.ProductModel;
import com.narektm.simplecrudforjenkins.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public ProductDto create(ProductModel model) {
        Product entity = productConverter.toEntity(model);
        productRepository.save(entity);

        return productConverter.toDto(entity);
    }

    public ProductDto getById(Long productId) {
        Product entity = productRepository.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        return productConverter.toDto(entity);
    }
}
