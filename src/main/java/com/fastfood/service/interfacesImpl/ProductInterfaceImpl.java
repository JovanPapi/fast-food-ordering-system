package com.fastfood.service.interfacesImpl;

import com.fastfood.Repository.ProductRepository;
import com.fastfood.model.DTO.ProductDTO;
import com.fastfood.model.Product;
import com.fastfood.model.User;
import com.fastfood.service.interfaces.ProductInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductInterfaceImpl implements ProductInterface {

    private final ProductRepository productRepository;

    public ProductInterfaceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveNewProduct(ProductDTO productDTO) {
        Product newProduct = new Product(UUID.randomUUID().toString(), productDTO.getName(),
                productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getIngredients(), productDTO.getType(), new ArrayList<>());

        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(Product product) {
        Product inDataBase = productRepository.findById(product.getId()).get();

        inDataBase.setDescription(product.getDescription());
        inDataBase.setIngredients(product.getIngredients());
        inDataBase.setName(product.getName());
        inDataBase.setPrice(product.getPrice());

        productRepository.save(inDataBase);
    }

    @Override
    public void deleteProduct(String productId) {
        Product deleteProduct = productRepository.findById(productId).get();

        productRepository.delete(deleteProduct);
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).get();
    }
}
