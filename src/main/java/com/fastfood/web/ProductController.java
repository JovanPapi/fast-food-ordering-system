package com.fastfood.web;

import com.fastfood.model.DTO.ProductDTO;
import com.fastfood.model.Product;
import com.fastfood.service.interfaces.ProductInterface;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductInterface productInterface;

    public ProductController(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    @GetMapping("/menu")
    private String fetchAllProducts(HttpSession session) {
        session.setAttribute("allProducts", productInterface.fetchProducts());

        return "menu-products";
    }

    // CREATE PRODUCT ACTIONS
    @GetMapping("/create-product")
    private String createProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "create-product";
    }

    @PostMapping("/save-product")
    private String saveNewProduct(ProductDTO productDTO) {
        productInterface.saveNewProduct(productDTO);
        return "redirect:/all-products";
    }

    // UPDATE EXISTING PRODUCT ACTIONS
    @GetMapping("/update-product/{id}")
    private String updateProductPage(@PathVariable String id, Model model) {
        model.addAttribute("productToUpdate", productInterface.findProductById(id));
        return "update-product";
    }

    @PostMapping("/update-product")
    private String updateProduct(Product product) {
        productInterface.updateProduct(product);
        return "/all-products";
    }

    // DELETE EXISTING PRODUCT ACTION
    @PostMapping("/delete-product/{id}")
    private String deleteProduct(@PathVariable String id) {
        productInterface.deleteProduct(id);
        return "redirect:/all-products";
    }

}
