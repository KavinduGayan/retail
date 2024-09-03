package com.example.retail.model

data class Product(val id: Long, val name: String, val description: String, val price: Double, val stock: Int, val categoryId: Long)