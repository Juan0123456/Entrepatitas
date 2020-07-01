package edu.cibertec.dto;

import java.io.Serializable;

public class TrabajadorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTrab;
	private String nombreTrab;
	private String apePatTrab;
	private String apeMatTrab;
	private String ruc;
	private int dni;
	private int telefono;
	private String correo;
	private String direccion;
	private String nombreimg;
	private DistritoDTO idDistrito;
	private OcupacionDTO idTecnico;
	private String contrasena;
	
	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getIdTrab() {
		return idTrab;
	}

	public void setIdTrab(int idTrab) {
		this.idTrab = idTrab;
	}

	public String getNombreTrab() {
		return nombreTrab;
	}

	public void setNombreTrab(String nombreTrab) {
		this.nombreTrab = nombreTrab;
	}

	public String getApePatTrab() {
		return apePatTrab;
	}

	public void setApePatTrab(String apePatTrab) {
		this.apePatTrab = apePatTrab;
	}

	public String getApeMatTrab() {
		return apeMatTrab;
	}

	public void setApeMatTrab(String apeMatTrab) {
		this.apeMatTrab = apeMatTrab;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreimg() {
		return nombreimg;
	}

	public void setNombreimg(String nombreimg) {
		this.nombreimg = nombreimg;
	}

	public DistritoDTO getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(DistritoDTO idDistrito) {
		this.idDistrito = idDistrito;
	}

	public OcupacionDTO getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(OcupacionDTO idTecnico) {
		this.idTecnico = idTecnico;
	}

}
