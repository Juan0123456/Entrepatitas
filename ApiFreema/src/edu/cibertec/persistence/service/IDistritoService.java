package edu.cibertec.persistence.service;


import java.util.List;


import edu.cibertec.entity.Distrito;


public interface IDistritoService {
		
	public List<Distrito> getDistritos()	throws Exception;
	public Distrito getDistritosPorCodigo(int id)	throws Exception;
	public Distrito registrar(Distrito Distrito) throws Exception;
	public Distrito actualizar(Distrito Distrito) throws Exception;
	public Distrito eliminar(int id) throws Exception;
	
}
