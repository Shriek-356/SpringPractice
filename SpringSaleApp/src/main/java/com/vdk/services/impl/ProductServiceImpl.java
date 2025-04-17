/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services.impl;

import com.vdk.pojo.Product;
import com.vdk.repositories.ProductRepository;
import com.vdk.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProduct(Map<String, String> params) {
        return this.productRepository.getProduct(params);
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public Product addOrUpdate(Product p) {
        return this.productRepository.addOrUpdate(p);
    }

    @Override
    public void deleteProduct(int id) {
          this.productRepository.deleteProduct(id);
    }
    
    
    
}
