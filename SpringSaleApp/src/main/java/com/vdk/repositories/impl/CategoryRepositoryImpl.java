/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.repositories.impl;

import com.vdk.pojo.Category;
import com.vdk.repositories.CategoryRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
@Transactional//kich hoat giao tac
public class CategoryRepositoryImpl implements CategoryRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    public List<Category> getCatesList(){
        
        Session s = this.factory.getObject().getCurrentSession();//Lay session Factory
            Query query = s.createQuery("from Category", Category.class);
            return query.getResultList();
        
        
    }
    
}
