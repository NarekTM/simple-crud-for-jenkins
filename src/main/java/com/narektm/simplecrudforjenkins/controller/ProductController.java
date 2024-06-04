package com.narektm.simplecrudforjenkins.controller;

import com.narektm.simplecrudforjenkins.dto.ProductDto;
import com.narektm.simplecrudforjenkins.model.ProductModel;
import com.narektm.simplecrudforjenkins.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductModel model) {
        return productService.create(model);
    }

    @GetMapping("/{productId}")
    public ProductDto getById(@PathVariable Long productId) {
        return productService.getById(productId);
    }
}
