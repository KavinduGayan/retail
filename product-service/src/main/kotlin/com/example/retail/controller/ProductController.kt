package com.example.retail.controller

import com.example.retail.model.Product
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getProducts(): List<Product> = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): Product = productService.getProductById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody product: Product): Product = productService.createProduct(product)

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody product: Product): Product =
        productService.updateProduct(id, product)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable id: Long) = productService.deleteProduct(id)
}
