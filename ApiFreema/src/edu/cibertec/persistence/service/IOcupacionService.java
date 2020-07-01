package edu.cibertec.persistence.service;


import java.util.List;

import edu.cibertec.entity.Ocupacion;
public interface IOcupacionService {
	
	public List<Ocupacion> getOcupaciones()	throws Exception;
	public Ocupacion getOcupacionPorCodigo(int id)	throws Exception;
	public Ocupacion registrar(Ocupacion Ocupacion) throws Exception;
	public Ocupacion actualizar(Ocupacion Ocupacion) throws Exception;
	public Ocupacion eliminar(int id) throws Exception;

}
