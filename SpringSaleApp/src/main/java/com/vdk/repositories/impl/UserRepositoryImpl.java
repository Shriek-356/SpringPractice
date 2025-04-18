/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.repositories.impl;

import com.vdk.pojo.User;
import com.vdk.repositories.UserRepository;
import jakarta.persistence.Query;
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
@Transactional
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public User getUserByName(String name){
        
        Session s = this.factory.getObject().getCurrentSession();
            
            Query q = s.createNamedQuery("User.findByUsername", User.class);
            
            q.setParameter("userName", name);
            
            return (User) q.getSingleResult();
            
   
    }
    
}
