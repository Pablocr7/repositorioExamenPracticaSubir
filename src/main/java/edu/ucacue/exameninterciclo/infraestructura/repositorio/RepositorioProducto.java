package edu.ucacue.exameninterciclo.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.ucacue.exameninterciclo.modelo.Producto;


	public interface RepositorioProducto extends JpaRepository<Producto, Integer>{

}
