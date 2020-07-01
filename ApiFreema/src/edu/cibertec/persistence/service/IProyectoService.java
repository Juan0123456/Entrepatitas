package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Proyecto;


public interface IProyectoService {

	public List<Proyecto> getProyectos(int id)	throws Exception;
	public Proyecto registrar(Proyecto Proyecto) throws Exception;
}
