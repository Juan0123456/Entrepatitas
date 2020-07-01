package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	@Id
	private int idCliente;
	private String nombreCli;
	private String apePatCli;
	private String apeMatCli;
	private String direccionCli;
	private String fecNacCli;
	private String correoCli;
	private int dniCli;
	private String nombreFotoCli;
	@ManyToOne
	@JoinColumn(name = "idDistrito")
	private Distrito distrito;
	private String contrasena;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public String getApePatCli() {
		return apePatCli;
	}

	public void setApePatCli(String apePatCli) {
		this.apePatCli = apePatCli;
	}

	public String getApeMatCli() {
		return apeMatCli;
	}

	public void setApeMatCli(String apeMatCli) {
		this.apeMatCli = apeMatCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getFecNacCli() {
		return fecNacCli;
	}

	public void setFecNacCli(String fecNacCli) {
		this.fecNacCli = fecNacCli;
	}

	public String getCorreoCli() {
		return correoCli;
	}

	public void setCorreoCli(String correoCli) {
		this.correoCli = correoCli;
	}

	public int getDniCli() {
		return dniCli;
	}

	public void setDniCli(int dniCli) {
		this.dniCli = dniCli;
	}

	public String getNombreFotoCli() {
		return nombreFotoCli;
	}

	public void setNombreFotoCli(String nombreFotoCli) {
		this.nombreFotoCli = nombreFotoCli;
	}

	public Distrito getIdDistrito() {
		return distrito;
	}

	public void setIdDistrito(Distrito idDistrito) {
		this.distrito = idDistrito;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
