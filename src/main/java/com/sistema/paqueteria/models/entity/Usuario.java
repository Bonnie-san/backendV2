package com.sistema.paqueteria.models.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.paqueteria.models.segurity.Authority;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private boolean enabled = true;  //habilitado
	private String perfil;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="usuario")    //OneToMany -> muchos roles le pueden permanecer a un usuario  //CascadeType.ALL -> Se aplican todos los tipos de cascada // FetchType.EAGER  (Ansioso) estar esperando //mappedBy ->  apunta a la identidad propietaria de la relacion     
	@JsonIgnore
	private Set<UsuarioRol> usuariosRoles = new HashSet<>();

	//get y set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<UsuarioRol> getUsuariosRoles() {
		return usuariosRoles;
	}

	public void setUsuariosRoles(Set<UsuarioRol> usuariosRoles) {
		this.usuariosRoles = usuariosRoles;
	}                        
	//constructor vacio
	public Usuario() {
		
	}
    //agregado de implements UserDetails   (Seguriudad)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// creamos un conjunto de autoridades
		Set<Authority> autoridades = new HashSet <>();
		this.usuariosRoles.forEach(usuarioRol ->{
			autoridades.add(new Authority(usuarioRol.getRol().getNombre()));
		});
		return autoridades;
		//obteniendo los nombres de los roles
	}

	@Override
	public boolean isAccountNonExpired() {
		// la cuenta va a espirar 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//las credenciales van a espirar
		return true;
	}
}
