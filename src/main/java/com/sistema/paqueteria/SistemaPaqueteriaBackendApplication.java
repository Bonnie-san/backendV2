package com.sistema.paqueteria;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.paqueteria.modelo.services.UsuarioService;
import com.sistema.paqueteria.models.entity.Rol;
import com.sistema.paqueteria.models.entity.Usuario;
import com.sistema.paqueteria.models.entity.UsuarioRol;

@SpringBootApplication
public class SistemaPaqueteriaBackendApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaPaqueteriaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario=new Usuario();
		
		usuario.setNombre("Ana");
		usuario.setApellido("Savedra");
		usuario.setUsername("Bonnie");
		usuario.setPassword("12345");
		usuario.setEmail("saavedra@gmail.com");
		usuario.setTelefono("5631426157");
		usuario.setPerfil("foto.png");
		
		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");
		
		Set<UsuarioRol> usuarioRoles= new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		
		Usuario usuarioGuardado =usuarioService.guardarusuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
		*/
	}

	
}
