package com.sistema.paqueteria.modelo.services;

import java.util.Set;
import com.sistema.paqueteria.models.entity.Usuario;
import com.sistema.paqueteria.models.entity.UsuarioRol;

public interface UsuarioService {
	public Usuario guardarusuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
	
	public Usuario obtenerUsuario(String username);
	
	public void eliminarUsuario(Long usuarioId);
}
