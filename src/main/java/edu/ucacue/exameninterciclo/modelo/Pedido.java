package edu.ucacue.exameninterciclo.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="pedidos")
public class Pedido {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEmision;
	
	@ManyToOne
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineaDePedido> LineasPedidos;

	

	public Pedido() {
		super();
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public Date getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<LineaDePedido> getLineasPedidos() {
		return LineasPedidos;
	}



	public void setLineasPedidos(List<LineaDePedido> lineasPedidos) {
		LineasPedidos = lineasPedidos;
	}


	
}
