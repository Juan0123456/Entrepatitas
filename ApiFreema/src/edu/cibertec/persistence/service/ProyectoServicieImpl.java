package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import edu.cibertec.entity.Proyecto;
import edu.cibertec.persistence.jpa.dao.ProyectoJPA;

public class ProyectoServicieImpl implements IProyectoService{

	
	static final Logger log = Logger.getLogger(ProyectoServicieImpl.class);
	ProyectoJPA proJPA = new ProyectoJPA();
	
	@Override
	public List<Proyecto> getProyectos(int id) throws Exception {
		log.info("Se ingreso a getProyectos()");
		List<Proyecto> lstTrab = new ArrayList<Proyecto>();
		proJPA.createEM();
		lstTrab = proJPA.getAll(id);
		proJPA.releaseEM();
		log.info("Se salio de getProyectos()");
		return lstTrab;
	}

	@Override
	public Proyecto registrar(Proyecto Proyecto) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			proJPA.createEM();
			proJPA.beginTransaction();
			proJPA.registrar(Proyecto);
			proJPA.flush();
			proJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Contrato");
			proJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

}
