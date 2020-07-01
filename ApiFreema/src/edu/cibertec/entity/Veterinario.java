package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario {
	@Id
	private int idVet;
	private String nombreVet;
	private String apePatVet;
	private String apeMatVet;
	private String ruc;
	private int dni;
	private int telefono;
	private String correo;
	private String direccion;
	private String nombreimg;
	@ManyToOne
	@JoinColumn(name = "idDistrito")
	private Distrito distrito;
	private String contrasena;
	
	public int getIdVet() {
		return idVet;
	}
	public void setIdVet(int idVet) {
		this.idVet = idVet;
	}
	
	public String getNombreVet() {
		return nombreVet;
	}
	public void setNombreVet(String nombreVet) {
		this.nombreVet = nombreVet;
	}
	
	public String getApePatVet() {
		return apePatVet;
	}
	public void setApePatVet(String apePatVet) {
		this.apePatVet = apePatVet;
	}
	
	public String getApeMatVet() {
		return apeMatVet;
	}
	public void setApeMatVet(String apeMatVet) {
		this.apeMatVet = apeMatVet;
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
