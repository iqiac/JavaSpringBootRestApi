package com.example.JavaSpringBootRestApi.controller;

import com.example.JavaSpringBootRestApi.entity.Product;
import com.example.JavaSpringBootRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // indicates that this class is a controller for RESTful API requests
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/v1") // base URL for all requests
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Create a new product
   * 
   * @param product the product to create
   * @return the ResponseEntity with status 200 (OK) and with body of the new
   *         product
   */
  @PostMapping("/product")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    Product newProduct = productService.saveProduct(product);
    return ResponseEntity.ok(newProduct);
  }

  /**
   * Get all products
   * 
   * @return the ResponseEntity with status 200 (OK) and with body of the list of
   *         products
   */
  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }

  /**
   * Get product by id
   * 
   * @param id the ID of the product
   * @return the ResponseEntity with status 200 (OK) and with body of the product
   */
  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Optional<Product> product = productService.getProductById(id);
    return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Update product by id
   * 
   * @param id      the ID of the product
   * @param product the updated product
   * @return the ResponseEntity with status 200 (OK) and with body of the updated
   *         product
   */
  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    Product updatedProduct = productService.updateProduct(id, product);
    return ResponseEntity.ok(updatedProduct);
  }

  /**
   * Delete product by id
   * 
   * @param id the ID of the product
   * @return the ResponseEntity with status 200 (OK) and with body of the message
   *         "Product deleted successfully"
   */
  @DeleteMapping("/products/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok("Product deleted successfully");
  }
}
