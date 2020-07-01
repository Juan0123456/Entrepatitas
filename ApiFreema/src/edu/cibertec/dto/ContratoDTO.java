package edu.cibertec.dto;

import java.io.Serializable;


public class ContratoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcontrato;
	private String fecha;
	private String descripcion;
	private ClienteDTO idCliente;
	private VeterinarioDTO idVet;

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

	public ClienteDTO getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteDTO idCliente) {
		this.idCliente = idCliente;
	}

	public VeterinarioDTO getIdVet() {
		return idVet;
	}

	public void setIdVet(VeterinarioDTO idVet) {
		this.idVet = idVet;
	}




}
