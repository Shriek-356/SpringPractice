/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.controllers;

import com.vdk.services.CategoryService;
import com.vdk.services.ProductService;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
@ControllerAdvice//Nhung controller khac deu se dung duoc commonResponse
public class indexController {
    
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute//tra ra response nay trong moi controller
    public void commonResponses(Model model){
        model.addAttribute("categories", this.categoryService.getCatesList());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("products",this.productService.getProduct(params));
        return "index";
    }
}
