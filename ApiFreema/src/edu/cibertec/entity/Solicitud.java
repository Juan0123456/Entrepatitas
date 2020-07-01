package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitud")
public class Solicitud {
		@Id
		private int idsolicitud;
		private String fecha;
		private String descripcion;
		private int idVet;
		public int getIdsolicitud() {
			return idsolicitud;
		}
		public void setIdsolicitud(int idsolicitud) {
			this.idsolicitud = idsolicitud;
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
		public int getIdVet() {
			return idVet;
		}
		public void setIdVet(int idVet) {
			this.idVet = idVet;
		}
		

		
		
}
