package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Contrato;
import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Servicio;
import edu.cibertec.entity.Solicitud;

public interface IServicioService {
	public List<Servicio> getServicios(int id)	throws Exception;
	public Servicio getServiciosPorCodigo(int id) throws Exception;
	public Servicio registrar(Servicio Servicio) throws Exception;
	public List<Servicio> getServiciosXVeterinario(int id)	throws Exception;
	public Servicio eliminar(int id) throws Exception;
	public Servicio actualizar(Servicio Servicio) throws Exception;
}
