package edu.ucacue.exameninterciclo.infraestructura.repositorio;


	import org.springframework.data.jpa.repository.JpaRepository;


import edu.ucacue.exameninterciclo.modelo.Pedido;

		public interface RepositorioPedido extends JpaRepository<Pedido, Integer>{
			
		}



