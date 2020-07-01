package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import edu.cibertec.entity.Trabajador;
import edu.cibertec.persistence.jpa.dao.TrabajadorJPA;

public class TrabajadorServicieImpl implements ITrabajadorService{

	
	static final Logger log = Logger.getLogger(TrabajadorServicieImpl.class);
	TrabajadorJPA trabJPA = new TrabajadorJPA();
	
	@Override
	public Trabajador getTrabajador(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trabajador> getTrabajadores() throws Exception {
		log.info("Se ingreso a getTrabajadores()");
		List<Trabajador> lstTrab = new ArrayList<Trabajador>();
		trabJPA.createEM();
		lstTrab = trabJPA.getAll();
		trabJPA.releaseEM();
		log.info("Se salio de getTrabajadores()");
		return lstTrab;
	}

	@Override
	public Trabajador registrar(Trabajador Trabajador) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			trabJPA.createEM();
			trabJPA.beginTransaction();
			trabJPA.registrar(Trabajador);
			trabJPA.flush();
			trabJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Contrato");
			trabJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Trabajador actualizar(Trabajador Trabajador) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			trabJPA.createEM();
			trabJPA.beginTransaction();
			trabJPA.actualizar(Trabajador);	
			trabJPA.flush();
			trabJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Ocupacion");
			trabJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Trabajador;
	}

	
	@Override
	public Trabajador getTrabajadorPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getTrabajadorPorCodigo()");
		Trabajador traList = null;

		trabJPA.createEM();
		traList = trabJPA.get(id);
		trabJPA.releaseEM();

		log.info("Saliendo de getTrabajadorPorCodigo()");

		return traList;
	}
	

	@Override
	public List<Trabajador> getTrabajadorPorCarrera(int id) throws Exception {
		log.info("Se ingreso a getTrabajadorPorCarrera()");
		List<Trabajador> traList = null;

		trabJPA.createEM();
		traList = trabJPA.TrabajadoresPorCarrera(id);
		trabJPA.releaseEM();

		log.info("Saliendo de getTrabajadorPorCarrera()");

		return traList;
	}

}
