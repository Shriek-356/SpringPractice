/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vdk.pojo.Product;
import com.vdk.repositories.ProductRepository;
import com.vdk.services.ProductService;
import java.io.IOException;
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

    @Autowired
    private Cloudinary cloudinary;

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

        if (!p.getFile().isEmpty()) { //Lay file anh
            
            try {
              Map res=  cloudinary.uploader().upload(p.getFile().getBytes(),ObjectUtils.asMap("resource_type", "auto"));
              p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return this.productRepository.addOrUpdate(p);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteProduct(id);
    }

}
