package com.narektm.simplecrudforjenkins.util;

import com.narektm.simplecrudforjenkins.entity.Product;

public class TestUtil {

    public static Product getProduct(Long productId, String productName, String productDescription) {
        Product product = new Product();

        product.setId(productId);
        product.setName(productName);
        product.setDescription(productDescription);

        return product;
    }
}
