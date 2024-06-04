package com.narektm.simplecrudforjenkins.converter;

import com.narektm.simplecrudforjenkins.dto.ProductDto;
import com.narektm.simplecrudforjenkins.entity.Product;
import com.narektm.simplecrudforjenkins.model.ProductModel;
import org.junit.jupiter.api.Test;

import static com.narektm.simplecrudforjenkins.util.TestUtil.getProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductConverterTest {

    private final ProductConverter converter = new ProductConverter();

    @Test
    void testToEntity_convertsModelToProduct() {
        ProductModel model = new ProductModel("Test Product", "This is a test description");

        Product product = converter.toEntity(model);

        assertEquals(model.name(), product.getName());
        assertEquals(model.description(), product.getDescription());
    }

    @Test
    void testToDto_convertsEntityToDto() {
        Product product = getProduct(1L, "Test Product", "This is a test description");

        ProductDto dto = converter.toDto(product);

        assertEquals(product.getId(), dto.id());
        assertEquals(product.getName(), dto.name());
        assertEquals(product.getDescription(), dto.description());
    }
}