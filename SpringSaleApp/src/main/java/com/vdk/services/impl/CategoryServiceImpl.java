/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services.impl;

import com.vdk.pojo.Category;
import com.vdk.repositories.CategoryRepository;
import com.vdk.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository cateRepo;
    
    
    @Override
    public List<Category> getCatesList() {
        return this.cateRepo.getCatesList();
    }
    
    
}
