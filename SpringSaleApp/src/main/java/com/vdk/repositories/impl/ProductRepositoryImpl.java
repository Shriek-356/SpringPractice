///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.vdk.repositories.impl;
//
//import com.mycompany.hibernatetest.HibernateUtils;
//import com.vdk.pojo.Product;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.hibernate.Session;
//
///**
// *
// * @author Asus
// */
//public class ProductRepositoryImpl {
//    /*
//    private static final int PAGE_SIZE =5; 
//    
//    public List<Product> getProduct(Map<String,String> params){
//        
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Product> q = b.createQuery(Product.class);
//            
//            Root root = q.from(Product.class);
//            q.select(root);
//            
//            if(params!=null){
//                
//                List<Predicate> predicates = new ArrayList<>();
//                
//               String kw = params.get("kw");
//                if(kw!=null&&!kw.isEmpty()){
//                    predicates.add(b.like(root.get("name"), String.format("%%%s%%",kw)));
//                }   
//                
//                String fromPrice = params.get("fromPrice");
//                if(fromPrice!=null&&!fromPrice.isEmpty()){
//                   predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
//                }
//                
//                String toPrice = params.get("toPrice");
//                if(toPrice!=null&&!toPrice.isEmpty()){
//                    predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
//                }
//                
//                String categoryId = params.get("categoryId");
//                if(categoryId!=null&&!categoryId.isEmpty()){
//                   predicates.add(b.equal(root.get("category").as(Integer.class), categoryId));
//                }
//                
//                q.where(predicates.toArray(Predicate[]::new));
//            }
//            
//            Query query = s.createQuery(q);
//            
//            if(params != null){
//                int page = Integer.parseInt(params.getOrDefault("page", "1"));
//                int start = (page -1 ) * PAGE_SIZE;
//                query.setMaxResults(PAGE_SIZE);
//                query.setFirstResult(start);    
//            }
//            
//            //query.setMaxResults(9);
//            //query.setFirstResult(1);
//            
//            return query.getResultList();
//            
//            
//        }
//    }
//    */
//    
//    public Product getProductById(int id){
//        
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            return s.get(Product.class, id);//product theo id
//        }
//    }
//    
//    
//    public Product addOrUpdate(Product p){
//         try(Session s = HibernateUtils.getFactory().openSession()){
//             
//             if(p.getId()==null){
//                 s.persist(p);
//             }
//             else{
//                 s.merge(p);
//             }
//             
//             s.refresh(p);//Cap nhat p de tra ve
//             
//             return p;
//         }
//    }
//    
//    public void deleteProduct(int id){
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            
//            Product p = s.get(Product.class, id);
//            s.remove(p);
//            
//         }
//    }
//}
