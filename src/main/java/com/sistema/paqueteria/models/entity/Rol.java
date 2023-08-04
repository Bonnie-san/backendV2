package com.sistema.paqueteria.models.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {

	@Id
	private Long rolId;
	private String nombre;
	
	@OneToMany (cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="rol")      //relacionado rol y usarios  // LAZY -> busqueda peresosa
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

	//get y set
	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}
	
	//constructor vacio
	public Rol() {
		
	}
}
