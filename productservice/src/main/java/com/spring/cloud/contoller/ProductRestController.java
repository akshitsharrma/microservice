package com.spring.cloud.contoller;

import com.spring.cloud.dto.Cupon;
import com.spring.cloud.model.ProductEntity;
import com.spring.cloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductRepository productRepository;
    @Value("${cupons.service.url}")
    private String url;

    @PostMapping("/products")
    private ProductEntity create(@RequestBody ProductEntity product) {
        Cupon cupon = restTemplate.getForObject(url+product.getCode(), Cupon.class);
        product.setPrice(product.getPrice().subtract(cupon.getDiscount()));
        ProductEntity save = productRepository.save(product);
        System.out.println("Product saved " + save);
        return save;
    }
}
