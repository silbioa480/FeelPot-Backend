package com.jh.feelpotbackend.repository;

import com.jh.feelpotbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
