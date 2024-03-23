package com.tobeto.pairwork_orm.controllers;

import com.tobeto.pairwork_orm.entities.Category;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody Product product){
        productRepository.save(product);
        return "Başarıyla eklendi";
    }

    @PutMapping
    public String update(@RequestBody Product product) {
        productRepository.save(product);
        return "Başarıyla güncellendi";
    }

    @DeleteMapping
    public String delete(@RequestParam int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product bulunamadı."));
        productRepository.delete(product);
        return "Başarıyla silindi";
    }

}
