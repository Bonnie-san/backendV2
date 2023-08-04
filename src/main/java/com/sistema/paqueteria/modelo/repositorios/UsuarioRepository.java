package com.sistema.paqueteria.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.paqueteria.models.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
