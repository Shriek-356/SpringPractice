/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.repositories.impl;

import com.vdk.pojo.Product;
import com.vdk.repositories.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ProductRepositoryImpl implements ProductRepository{
    
    private static final int PAGE_SIZE =5; 
    @Autowired
    private LocalSessionFactoryBean factory;
    
    public List<Product> getProduct(Map<String,String> params){
        
        
        Session s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            
            Root root = q.from(Product.class);
            q.select(root);
            
            if(params!=null){
                
                List<Predicate> predicates = new ArrayList<>();
                
               String kw = params.get("kw");
                if(kw!=null&&!kw.isEmpty()){
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%",kw)));
                }   
                
                String fromPrice = params.get("fromPrice");
                if(fromPrice!=null&&!fromPrice.isEmpty()){
                   predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
                }
                
                String toPrice = params.get("toPrice");
                if(toPrice!=null&&!toPrice.isEmpty()){
                    predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
                }
                
                String categoryId = params.get("categoryId");
                if(categoryId!=null&&!categoryId.isEmpty()){
                   predicates.add(b.equal(root.get("categoryId").as(Integer.class), categoryId));
                }
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q);
            
            if(params != null){
                int page = Integer.parseInt(params.getOrDefault("page", "1"));
                int start = (page -1 ) * PAGE_SIZE;
                query.setMaxResults(PAGE_SIZE);
                query.setFirstResult(start);    
            }
            
            return query.getResultList();
                  
    }
    
    
    public Product getProductById(int id){
        
        Session s = this.factory.getObject().getCurrentSession();
            return s.get(Product.class, id);//product theo id
        
    }
    
    
    public Product addOrUpdate(Product p){
        
        Session s = this.factory.getObject().getCurrentSession();
                   
             if(p.getId()==null){
                 s.persist(p);
             }
             else{
                 s.merge(p);
             }
             
             s.refresh(p);//Cap nhat p de tra ve
             
             return p;
         
    }
    
    public void deleteProduct(int id){
            
        Session s = this.factory.getObject().getCurrentSession();
            Product p = s.get(Product.class, id);
            s.remove(p);
            
    }
}
