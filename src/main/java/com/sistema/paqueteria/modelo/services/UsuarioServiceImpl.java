package com.sistema.paqueteria.modelo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.paqueteria.modelo.repositorios.RolRepository;
import com.sistema.paqueteria.modelo.repositorios.UsuarioRepository;
import com.sistema.paqueteria.models.entity.Usuario;
import com.sistema.paqueteria.models.entity.UsuarioRol;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Usuario guardarusuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal= usuarioRepository.findByUsername(usuario.getUsername());
		if(usuarioLocal != null) {         //si existe entonces no se puede registrar
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}
		else {                             // si no existe guarda
			for(UsuarioRol usuarioRol:usuarioRoles) {  
				rolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuariosRoles().addAll(usuarioRoles);
			usuarioLocal=usuarioRepository.save(usuario);
		}
		
		return usuarioLocal;
		
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}
	
	
}
