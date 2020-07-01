package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Servicio;

import edu.cibertec.persistence.jpa.dao.ServicioJPA;

public class ServicioServiceImpl implements IServicioService{
	
	static final Logger log = Logger.getLogger(ServicioServiceImpl.class);
	ServicioJPA serJPA = new ServicioJPA();

	@Override
	public List<Servicio> getServicios(int id) throws Exception {
		log.info("Se ingreso a getProyectos()");
		List<Servicio> lstSer = new ArrayList<Servicio>();
		serJPA.createEM();
		lstSer = serJPA.getAll(id);
		serJPA.releaseEM();
		log.info("Se salio de getServicios()");
		return lstSer;
	}

	@Override
	public Servicio registrar(Servicio Servicio) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			serJPA.createEM();
			serJPA.beginTransaction();
			serJPA.registrar(Servicio);
			serJPA.flush();
			serJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Servicio");
			serJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public List<Servicio> getServiciosXVeterinario(int id) throws Exception {
		log.info("Se ingreso a getContratosXClientes()");
		List<Servicio> resList = null;

		serJPA.createEM();
		resList = serJPA.getServiciosXVeterinario(id);
		serJPA.releaseEM();

		log.info("Saliendo de getServiciosXVeterinarios()");

		return resList;
	}

	@Override
	public Servicio eliminar(int id) throws Exception {
		log.info("Se ingreso a eliminar()");
		Servicio traList = null;
		try {
			serJPA.createEM();
			serJPA.beginTransaction();
			traList = serJPA.get(id);
			serJPA.eliminar(traList);
			serJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal en eliminar Ocupacion");
			serJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de eliminar()");
		return traList;
	}

	@Override
	public Servicio actualizar(Servicio Servicio) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			serJPA.createEM();
			serJPA.beginTransaction();
			serJPA.actualizar(Servicio);	
			serJPA.flush();
			serJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Ocupacion");
			serJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Servicio;
	}

	@Override
	public Servicio getServiciosPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getServiciosPorCodigo()");
		Servicio traList = null;

		serJPA.createEM();
		traList = serJPA.get(id);
		serJPA.releaseEM();

		log.info("Saliendo de getServiciosPorCodigo()");

		return traList;
	}



}
