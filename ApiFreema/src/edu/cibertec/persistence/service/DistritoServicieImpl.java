package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import edu.cibertec.entity.Distrito;

import edu.cibertec.persistence.jpa.dao.DistritoJPA;

public class DistritoServicieImpl implements IDistritoService{

	
	static final Logger log = Logger.getLogger(DistritoServicieImpl.class);
	DistritoJPA distritosJPA = new DistritoJPA();
	
	@Override
	public Distrito registrar(Distrito Distrito) throws Exception {
	log.info("Se ingreso a registrar()");
		
		try {
			distritosJPA.createEM();
			distritosJPA.beginTransaction();
			distritosJPA.registrar(Distrito);
			distritosJPA.flush();
			distritosJPA.endTransaction();	
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Contrato");
			distritosJPA.rollbackTransaction();
			log.fatal("Exception: ",e);
		}
		
		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public List<Distrito> getDistritos() throws Exception {
		log.info("Se ingreso a getDistritos()");
		List<Distrito> lstDist = new ArrayList<Distrito>();
		distritosJPA.createEM();
		lstDist = distritosJPA.getAll();
		distritosJPA.releaseEM();
		log.info("Se salio de getDistritos()");
		return lstDist;
	}

	@Override
	public Distrito getDistritosPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getDistritosPorCodigo()");
		Distrito traList = null;

		distritosJPA.createEM();
		traList = distritosJPA.get(id);
		distritosJPA.releaseEM();

		log.info("Saliendo de getDistritosPorCodigo()");

		return traList;
	}

	@Override
	public Distrito actualizar(Distrito Distrito) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			distritosJPA.createEM();
			distritosJPA.beginTransaction();
			distritosJPA.actualizar(Distrito);	
			distritosJPA.flush();
			distritosJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Ocupacion");
			distritosJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Distrito;
	}

	@Override
	public Distrito eliminar(int id) throws Exception {
		log.info("Se ingreso a eliminar()");
		Distrito traList = null;
		try {
			distritosJPA.createEM();
			distritosJPA.beginTransaction();
			traList = distritosJPA.get(id);
			distritosJPA.eliminar(traList);
			distritosJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal en eliminar Ocupacion");
			distritosJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de eliminar()");
		return traList;
	}
	
	
	
	

}
