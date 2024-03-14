package com.spring.cloud.contoller;

import com.spring.cloud.model.ProductEntity;
import com.spring.cloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    private ProductEntity create(@RequestBody ProductEntity product){
        ProductEntity save = productRepository.save(product);
        System.out.println("Product saved "+save);
        return save;
    }
}
