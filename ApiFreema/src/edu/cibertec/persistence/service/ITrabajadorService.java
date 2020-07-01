package edu.cibertec.persistence.service;

import java.util.List;


import edu.cibertec.entity.Trabajador;

public interface ITrabajadorService {
	
	public Trabajador getTrabajador(Integer id) throws Exception;
	public List<Trabajador> getTrabajadores()	throws Exception;
	public Trabajador getTrabajadorPorCodigo(int id)	throws Exception;
	public List<Trabajador> getTrabajadorPorCarrera(int id)	throws Exception;
	public Trabajador registrar(Trabajador Trabajador) throws Exception;
	public Trabajador	actualizar(Trabajador Trabajador) throws Exception;
	

}
