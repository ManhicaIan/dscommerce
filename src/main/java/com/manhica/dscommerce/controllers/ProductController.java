package com.manhica.dscommerce.controllers;

import com.manhica.dscommerce.dto.ProductDTO;
import com.manhica.dscommerce.repositories.ProductRepository;
import com.manhica.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping
    public Page<ProductDTO> findAllByPage(Pageable pageable){
        return service.findAllByPage(pageable);
    }
}
