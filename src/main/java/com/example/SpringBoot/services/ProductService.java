package com.example.SpringBoot.services;

import com.example.SpringBoot.models.ProductModel;
import com.example.SpringBoot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductModel findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto nao encontrado!"));
    }

    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public List<ProductModel> findAll () {
        return productRepository.findAll();
    }


}
