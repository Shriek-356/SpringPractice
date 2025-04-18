/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services;

import com.vdk.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Asus
 */
public interface UserService extends UserDetailsService{
    public User getUserByName(String name);
}
