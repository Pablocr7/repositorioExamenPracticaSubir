package edu.ucacue.exameninterciclo.infraestructura.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucacue.exameninterciclo.modelo.Cliente;

	public interface RepositorioCliente extends JpaRepository<Cliente, Integer>{
		
	}


