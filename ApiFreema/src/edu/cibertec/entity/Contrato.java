package edu.cibertec.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contrato")
public class Contrato {
	@Id
	private int idcontrato;
	private String fecha;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "idVet")
	private Veterinario veterinario;

	public int getIdcontrato() {
		return idcontrato;
	}

	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getIdCliente() {
		return cliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.cliente = idCliente;
	}

	public Veterinario getIdVet() {
		return veterinario;
	}

	public void setIdVet(Veterinario idVet) {
		this.veterinario = idVet;
	}

}
