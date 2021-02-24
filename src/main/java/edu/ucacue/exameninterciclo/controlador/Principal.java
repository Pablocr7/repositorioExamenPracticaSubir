package edu.ucacue.exameninterciclo.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.ucacue.exameninterciclo.infraestructura.repositorio.RepositorioCliente;
import edu.ucacue.exameninterciclo.infraestructura.repositorio.RepositorioLineaDePedidos;
import edu.ucacue.exameninterciclo.infraestructura.repositorio.RepositorioPedido;
import edu.ucacue.exameninterciclo.infraestructura.repositorio.RepositorioProducto;
import edu.ucacue.exameninterciclo.modelo.Cliente;
import edu.ucacue.exameninterciclo.modelo.LineaDePedido;
import edu.ucacue.exameninterciclo.modelo.Pedido;





@Controller
public class Principal {
	
	@Autowired
	RepositorioPedido Repositoriopedido;
	
	@Autowired
	RepositorioCliente Repositoriocliente;
	
	@Autowired
	RepositorioLineaDePedidos Repositoriolineadepedido;
	
	@Autowired
	RepositorioProducto Repositorioproducto;
	
	public void interfaz( ) {
		Scanner input = new Scanner(System.in);
		boolean mainLoop = true;
		
		
		int choice;
		while (true) {
			System.out.println("Menu\n");
			System.out.print("1.) Realizar pedido \n");
			System.out.print("2.) Guardar usuario \n");
			System.out.print("3.) Eliminar.\n");
			System.out.print("4.) Listar usuario.\n");
			System.out.print("5.) Salir.\n");
			
			System.out.print("\n Ingrese la opcion del Menú: ");

			choice = input.nextInt();
			switch (choice) {

			case 1:
				try {
					System.out.print("Ingrese el id de la persona qpara generar el pedido: ");
					int idcli = input.nextInt();
					Cliente cf = Repositoriocliente.findById(idcli).get();
					if (cf == null) {
						System.out.println("ID no encontrada");
					}	
					Pedido fc = new Pedido();
					fc.setCliente(cf);
					System.out.print("Ingrese el número de pedido");
					int nf = input.nextInt();
					fc.setNumero(nf);
					fc.setFechaEmision(new Date());
					List<LineaDePedido> detalles = new ArrayList<>();
					System.out.println("Ingrese el número de pedidos");
					int numPedidos = input.nextInt();
					for (int i = 0; i < numPedidos; i++) {
						System.out.println("Detalle pedido"+i+1);
						LineaDePedido df= new LineaDePedido();
						df.setPedido(fc);

						System.out.print("Ingrese la cantidad: ");
						int cantidad = input.nextInt();
						df.setCantidad(cantidad);

						System.out.print("Ingrese el precio Unitario: ");
						double precioU = input.nextDouble();
						df.setPrecioUnitario(precioU);
						
						System.out.print("Ingrese el descuento: ");
						double descuento = input.nextDouble();
						df.setDescuento(descuento);
						
						detalles.add(df);
						fc.setDetalles(detalles);
						Repositoriopedido.save(fc);
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
				
			case 2:
				try {
					String nif, nombre, direccion;
					System.out.print("Ingrese el nif del usuario: ");
					nif = input.next();
					System.out.print("Ingrese el Nombre: ");
					nombre = input.next();
					System.out.print("Ingrese la dirección: ");
					direccion = input.next();

					Cliente p = new Cliente(nif, nombre, direccion);

					Repositoriocliente.save(p);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 3:
				
				try {
					System.out.println("Ingrese el id del usuario que desea eliminar");
					int id = input.nextInt();
					Repositoriocliente.deleteById(id);
					Repositoriopedido.deleteById(id);
					Repositoriolineadepedido.deleteById(id);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
				
			case 4:
				try {		
				List<Cliente> clientes = Repositoriocliente.findAll();
				
				for (Cliente cliente : clientes) {
					System.out.println(cliente);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			break;
			case 5:
				try {
					System.exit(0);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
				
			default:
				System.out.println("Esta no es una opcion valida del Menu. Porfavor seleccione otra");
				break;
			}
		}
	}
	public void insertarPersona(Cliente p) {
		try {
			Repositoriocliente.save(p);
		} catch (Exception e) {
			System.out.println("Error al insertar los datos");
		}
	}

	public void listarPersonas() {
		List<Cliente> clientes = Repositoriocliente.findAll();

		for (Cliente persona : clientes) {
			System.out.println(persona);
		}
	}

	public void listarPersonasById(int id) {
		try {
			Cliente persona = Repositoriocliente.findById(id).get();
			System.out.println(persona);
		} catch (Exception e) {
			System.out.println("No se encuentra a la persona");
		}

	}
}
