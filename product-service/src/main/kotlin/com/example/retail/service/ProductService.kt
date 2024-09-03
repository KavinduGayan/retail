package com.example.retail.service

import com.example.retail.model.Product
import com.example.retail.repository.ProductRepository

interface ProductService {
    fun getAllProducts(): List<Product>
    fun getProductById(id: Long): Product
    fun createProduct(product: Product): Product
    fun updateProduct(id: Long, product: Product): Product
    fun deleteProduct(id: Long)
}

class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun getAllProducts(): List<Product> = productRepository.findAll()

    override fun getProductById(id: Long): Product = productRepository.findById(id)
        .orElseThrow { NoSuchElementException("Product not found with id: $id") }

    override fun createProduct(product: Product): Product = productRepository.save(product)

    override fun updateProduct(id: Long, product: Product): Product {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product not found with id: $id")
        }
        return productRepository.save(product.copy(id = id))
    }

    override fun deleteProduct(id: Long) {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product not found with id: $id")
        }
        productRepository.deleteById(id)
    }
}