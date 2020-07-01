package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_proyecto")
public class Proyecto {
	@Id
	private int idProyecto;
	private String nomProyecto;
	private String fechInicio;
	private String fechFin;
	private String rucEmpresa;
	@ManyToOne
	@JoinColumn(name = "idTrab")
	private Trabajador trabajador;

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

	public Trabajador getIdTrab() {
		return trabajador;
	}

	public void setIdTrab(Trabajador idTrab) {
		this.trabajador = idTrab;
	}

}
