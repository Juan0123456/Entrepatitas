package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_profesionalTecnico")
public class Ocupacion {
	@Id
	private int idTecnico;
	private String nomTecnico;

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getNomTecnico() {
		return nomTecnico;
	}

	public void setNomTecnico(String nomTecnico) {
		this.nomTecnico = nomTecnico;
	}

}
