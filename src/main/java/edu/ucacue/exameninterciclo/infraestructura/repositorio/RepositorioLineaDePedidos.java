package edu.ucacue.exameninterciclo.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.ucacue.exameninterciclo.modelo.LineaDePedido;

	public interface RepositorioLineaDePedidos extends JpaRepository<LineaDePedido, Integer>{
		
	}
