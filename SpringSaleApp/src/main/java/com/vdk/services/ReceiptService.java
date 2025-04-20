/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services;

import com.vdk.pojo.Cart;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ReceiptService {
    public void addReceipt(List<Cart> carts);
}
