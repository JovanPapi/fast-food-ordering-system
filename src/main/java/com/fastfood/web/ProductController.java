package com.fastfood.web;

import com.fastfood.model.DTO.ProductDTO;
import com.fastfood.model.Product;
import com.fastfood.service.interfaces.ProductInterface;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        session.setAttribute("burgers", productInterface.fetchProducts()
                .stream()
                .filter(product -> product.getType().equals("burger"))
                .collect(Collectors.toList()));

        session.setAttribute("chicken", productInterface.fetchProducts()
                .stream()
                .filter(product -> product.getType().equals("chickenAndSandwich"))
                .collect(Collectors.toList()));

        session.setAttribute("drinks", productInterface.fetchProducts()
                .stream()
                .filter(product -> product.getType().equals("drink"))
                .collect(Collectors.toList()));

        session.setAttribute("comboMeal", productInterface.fetchProducts()
                .stream()
                .filter(product -> product.getType().equals("comboMeal"))
                .collect(Collectors.toList()));

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
        return "redirect:/products/menu";
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
        return "redirect:/products/menu";
    }

    // DELETE EXISTING PRODUCT ACTION
    @PostMapping("/delete-product/{id}")
    private String deleteProduct(@PathVariable String id) {
        productInterface.deleteProduct(id);
        return "redirect:/products/menu";
    }

    @GetMapping("/add-to-cart/{id}")
    private String addToCardProduct(@PathVariable String id) {
        productInterface.addToCartProduct(id);
        return "redirect:/products/menu";
    }

}
