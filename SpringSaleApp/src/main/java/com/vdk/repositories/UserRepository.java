/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.repositories;

import com.vdk.pojo.User;

/**
 *
 * @author Asus
 */
public interface UserRepository {
    public User getUserByName(String name);
}
