/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "user_rol")
public class UserRol implements Serializable {
    
      
        @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")
        @ManyToOne
        private Rol rol;
        
        
	@JoinColumn(name = "user_id", referencedColumnName = "id_user")
        @ManyToOne
	private Usuario usuario;
        
        @Id
	@Column(name = "user_id")
	private int idUser;

	@Id
	@Column(name = "rol_id")
	private int idRol;
    
    
    
}
