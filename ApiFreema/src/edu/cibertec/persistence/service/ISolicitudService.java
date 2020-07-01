package edu.cibertec.persistence.service;

import java.util.List;


import edu.cibertec.entity.Solicitud;

public interface ISolicitudService {
	public List<Solicitud> getSolicitudes() throws Exception;
	public Solicitud getSolicitudPorCodigo(int id)	throws Exception;
	public List<Solicitud> getSolicitudXClientes(int id)	throws Exception;
	public Solicitud registrar(Solicitud Solicitud) throws Exception;
	public Solicitud eliminar(int id) throws Exception;

}
