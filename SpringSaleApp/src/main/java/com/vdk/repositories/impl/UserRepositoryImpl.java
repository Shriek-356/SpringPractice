///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.vdk.repositories.impl;
//
//import com.mycompany.hibernatetest.HibernateUtils;
//import com.vdk.pojo.User;
//import jakarta.persistence.Query;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//
///**
// *
// * @author Asus
// */
//public class UserRepositoryImpl {
//    
//    public User getUserByName(String name){
//        
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            
//            Query q = s.createNamedQuery("User.findByUsername", User.class);
//            
//            q.setParameter("userName", name);
//            
//            return (User) q.getSingleResult();
//            
//        }     
//    }
//    
//}
