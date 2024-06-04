package com.narektm.simplecrudforjenkins.service;

import com.narektm.simplecrudforjenkins.converter.ProductConverter;
import com.narektm.simplecrudforjenkins.entity.Product;
import com.narektm.simplecrudforjenkins.model.ProductModel;
import com.narektm.simplecrudforjenkins.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.narektm.simplecrudforjenkins.util.TestUtil.getProduct;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductConverter productConverter;

    @Test
    void testCreate_callsRepositorySaveOnce() {
        ProductModel model = new ProductModel("Test Product", "This is a test description");
        Product entity = new Product();

        when(productConverter.toEntity(model)).thenReturn(entity);

        productService.create(model);

        verify(productRepository).save(entity);
    }

    @Test
    void testGetById_callsRepositoryFindByIdOnce() {
        Long productId = 1L;
        Product product = getProduct(productId, "Test Product", "This is a test description");

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        productService.getById(productId);

        verify(productRepository).findById(productId);
    }
}