package com.example.JavaSpringBootRestApi.repository;

import com.example.JavaSpringBootRestApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// In context of Spring Data JPA, a repository is an interface
// that defines methods for interacting with a database to perform
// CRUD (create, read, update, delete) operations.
@Repository // specifies that this is a Spring Data JPA repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
