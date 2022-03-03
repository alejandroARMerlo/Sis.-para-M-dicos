/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.controller;


import javax.faces.event.ActionEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserController {
    
    private boolean isIniciarSesion;
         
    
    public void loadSessionForm(ActionEvent actionEvent){             
                  
             
                             
                isIniciarSesion=true;      
               
         }

    public void setIsIniciarSesion(boolean isIniciarSesion) {
        this.isIniciarSesion = isIniciarSesion;
    }

    public boolean getIsIniciarSesion() {
        return isIniciarSesion;
    }
    
         
    
}
