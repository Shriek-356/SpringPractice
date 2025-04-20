/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdk.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vdk.pojo.User;
import com.vdk.repositories.UserRepository;
import com.vdk.services.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Service
public class UserServiceImpl implements UserService {//Spring security yeu cau 1 service de tim nguoi dung theo ten dang nhap

    @Autowired
    private UserRepository u;
    
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUserByName(String name) {//la ha`m nay
        return this.u.getUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//goi khi nguoi dung dang nhap
        User u = this.getUserByName(username);

        if (u == null) {
            throw new UsernameNotFoundException("Invalid username");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));

        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User addUser(Map<String, String> params, MultipartFile avatar) {
        User u = new User();
        u.setFirstName(params.get("firstname"));
        u.setLastName(params.get("lastname"));
        u.setUsername(params.get("username"));
        u.setPhone(params.get("phone"));
        u.setEmail(params.get("email"));
        u.setPassword(this.passwordEncoder.encode(params.get("password")));
        u.setUserRole("ROLE_USER");
        if(!avatar.isEmpty()){
            try {
              Map res=  cloudinary.uploader().upload(avatar.getBytes(),ObjectUtils.asMap("resource_type", "auto"));
              u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return this.u.addUser(u);
       
    }

}
