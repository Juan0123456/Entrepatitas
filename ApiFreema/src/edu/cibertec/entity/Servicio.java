package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "tb_servicio")
public class Servicio {
	@Id
	private int idServicio;
	private String nomServicio;
	private double costoServicio;
	private int idVet;
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNomServicio() {
		return nomServicio;
	}
	public void setNomServicio(String nomServicio) {
		this.nomServicio = nomServicio;
	}
	public double getCostoServicio() {
		return costoServicio;
	}
	public void setCostoServicio(double costoServicio) {
		this.costoServicio = costoServicio;
	}
	public int getIdVet() {
		return idVet;
	}
	public void setIdVet(int idVet) {
		this.idVet = idVet;
	}

	

}
