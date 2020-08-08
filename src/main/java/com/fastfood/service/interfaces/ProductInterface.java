package com.fastfood.service.interfaces;

import com.fastfood.model.DTO.ProductDTO;
import com.fastfood.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInterface {

    List<Product> fetchProducts();

    void saveNewProduct(ProductDTO productDTO);

    void updateProduct(Product product);

    void deleteProduct(String productId);

    Product findProductById(String id);
}
