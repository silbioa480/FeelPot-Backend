package com.jh.feelpotbackend.controller;

import com.jh.feelpotbackend.exception.ResourceNotFoundException;
import com.jh.feelpotbackend.model.Product;
import com.jh.feelpotbackend.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://silbioa480.github.io/")
@RestController
@RequestMapping("/api/")
public class ProductController {
  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @PostMapping("/products")
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable long id) {
    Product product = productRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Product not exsit with id:" + id));

    return ResponseEntity.ok(product);
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateMember(@PathVariable long id, @RequestBody Product changedProduct) {
    Product product = productRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Product not exsit with id:" + id));

    product.setName(changedProduct.getName());
    product.setPrice(changedProduct.getPrice());
    product.setImage(changedProduct.getImage());
    product.setDescription(changedProduct.getDescription());

    Product updateProduct = productRepository.save(product);

    return ResponseEntity.ok(updateProduct);
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable long id) {
    Product product = productRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Product not exsit with id:" + id));

    productRepository.delete(product);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delte", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
