/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.repositories;

import com.vdk.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public interface ProductRepository {
    public List<Product> getProduct(Map<String,String> params);
    public Product getProductById(int id);
    public Product addOrUpdate(Product p);
    public void deleteProduct(int id);
}
