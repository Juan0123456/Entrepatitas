package edu.cibertec.dto;

import java.io.Serializable;

public class ProyectoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProyecto;
	private String nomProyecto;
	private String fechInicio;
	private String fechFin;
	private String rucEmpresa;
	private TrabajadorDTO idTrab;

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNomProyecto() {
		return nomProyecto;
	}

	public void setNomProyecto(String nomProyecto) {
		this.nomProyecto = nomProyecto;
	}

	public String getFechInicio() {
		return fechInicio;
	}

	public void setFechInicio(String fechInicio) {
		this.fechInicio = fechInicio;
	}

	public String getFechFin() {
		return fechFin;
	}

	public void setFechFin(String fechFin) {
		this.fechFin = fechFin;
	}

	public String getRucEmpresa() {
		return rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public TrabajadorDTO getIdTrab() {
		return idTrab;
	}

	public void setIdTrab(TrabajadorDTO idTrab) {
		this.idTrab = idTrab;
	}

}
