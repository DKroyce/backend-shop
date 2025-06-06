package com.example.Groceris.repo;
import com.example.Groceris.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends  JpaRepository<Product,Integer> {

}
