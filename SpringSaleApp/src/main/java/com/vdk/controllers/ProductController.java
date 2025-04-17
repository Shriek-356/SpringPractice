/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.controllers;

import com.vdk.pojo.Product;
import com.vdk.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String productView(Model model) {

        model.addAttribute("product", new Product());

        return "products";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute (value="product") Product p){//product ban dau la rong, sau khi xu ly form xong se gui lai product cho cai nay
        
        this.productService.addOrUpdate(p);
        
        return "redirect:/";
    }
    
}
