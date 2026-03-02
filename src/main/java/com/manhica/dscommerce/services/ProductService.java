package com.manhica.dscommerce.services;

import com.manhica.dscommerce.dto.ProductDTO;
import com.manhica.dscommerce.entities.Product;
import com.manhica.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllByPage(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(product -> new ProductDTO(product));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product();
        product.copyDto(dto);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        Product product = repository.getReferenceById(id);
        product.copyDto(dto);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
