package com.sistema.paqueteria.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.paqueteria.models.entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long>{
	
}
