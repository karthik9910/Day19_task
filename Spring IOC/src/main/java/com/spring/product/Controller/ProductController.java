package com.spring.product.Controller;

import com.spring.product.Entity.Product;
import com.spring.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/display-products")
    public String displayProducts(Model model, @RequestParam(required = false) String category) {
        List<Product> products;
        if (category != null && !category.isEmpty()) {
//            products =productService.getProductsByCategory(category);
            products = productService.getProductsByCategory(category);
        } else {
            products = productService.getAllProducts();
        }
        model.addAttribute("products", products);
        return "display-products";
    }
}