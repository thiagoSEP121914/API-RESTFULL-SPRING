package com.example.SpringBoot.controllers;

import com.example.SpringBoot.dtos.ProductRecordDto;
import com.example.SpringBoot.models.ProductModel;
import com.example.SpringBoot.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<String> getProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Hello world");
    }

    @GetMapping("/products/findAll")
    public ResponseEntity<List<ProductModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> findById (@PathVariable(value = "id") UUID id) {
        ProductModel product = service.findById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(productModel));
    }

}
