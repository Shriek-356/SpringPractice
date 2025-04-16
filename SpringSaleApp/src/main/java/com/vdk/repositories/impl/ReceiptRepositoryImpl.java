///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.vdk.repositories.impl;
//
//import com.mycompany.hibernatetest.HibernateUtils;
//import com.vdk.pojo.Cart;
//import com.vdk.pojo.OrderDetail;
//import com.vdk.pojo.SaleOrder;
//import java.util.Date;
//import java.util.Map;
//import org.hibernate.Session;
//
///**
// *
// * @author Asus
// */
//public class ReceiptRepositoryImpl {
//    
//    public void addReceipt(Map<String, Cart> carts){
//     
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            SaleOrder r = new SaleOrder();
//            r.setCreatedDate(new Date());
//            r.setUserId(new UserRepositoryImpl().getUserByName("dhthanh"));
//            s.persist(r);
//            
//            for(var c:carts.values()){
//                OrderDetail d = new OrderDetail();
//                d.setQuantity(c.getQuantity());
//                d.setUnitPrice(c.getPrice());
//                d.setProductId(new ProductRepositoryImpl().getProductById(c.getId()));
//                d.setOrderId(r);
//                
//                s.persist(d);
//            }
//        }
//    }
//    
//}
