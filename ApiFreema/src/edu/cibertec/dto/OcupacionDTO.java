package edu.cibertec.dto;

import java.io.Serializable;

public class OcupacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
