/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.service;

import com.alejandro.Dao.UserDao;
import com.alejandro.model.UserRol;
import com.alejandro.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<Usuario> listUser() {  
        
     
           return userDao.findAll();
        }
   
    
        @Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario= userDao.findByUserName(username);
		
		if (usuario==null) {
			
			throw new UsernameNotFoundException(username);			
		}
		
		List<GrantedAuthority> roles= new ArrayList<GrantedAuthority>();
		
		for (UserRol rol : usuario.getUserRols()) {
			
			roles.add(new SimpleGrantedAuthority(rol.getRol().getRolName()));			
		}		
		
		return new User(usuario.getUserName(), usuario.getPass(), roles);
	}
    

}
    





