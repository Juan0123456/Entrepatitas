package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import edu.cibertec.entity.Ocupacion;
import edu.cibertec.persistence.jpa.dao.OcupacionJPA;

public class OcupacionServicieImpl implements IOcupacionService {
	static final Logger log = Logger.getLogger(OcupacionServicieImpl.class);
	OcupacionJPA ocupacionJPA = new OcupacionJPA();

	@Override
	public List<Ocupacion> getOcupaciones() throws Exception {
		log.info("Se ingreso a getOcupaciones()");
		List<Ocupacion> lstOcu = new ArrayList<Ocupacion>();
		ocupacionJPA.createEM();
		lstOcu = ocupacionJPA.getAll();
		ocupacionJPA.releaseEM();
		log.info("Se salio de getOcupaciones()");
		return lstOcu;
	}

	@Override
	public Ocupacion registrar(Ocupacion Ocupacion) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			ocupacionJPA.createEM();
			ocupacionJPA.beginTransaction();
			ocupacionJPA.registrar(Ocupacion);
			ocupacionJPA.flush();
			ocupacionJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Contrato");
			ocupacionJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Ocupacion actualizar(Ocupacion Ocupacion) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			ocupacionJPA.createEM();
			ocupacionJPA.beginTransaction();
			ocupacionJPA.actualizar(Ocupacion);	
			ocupacionJPA.flush();
			ocupacionJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Ocupacion");
			ocupacionJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Ocupacion;
	}

	@Override
	public Ocupacion eliminar(int id) throws Exception {
		log.info("Se ingreso a eliminar()");
		Ocupacion traList = null;
		try {
			ocupacionJPA.createEM();
			ocupacionJPA.beginTransaction();
			traList = ocupacionJPA.get(id);
			ocupacionJPA.eliminar(traList);
			ocupacionJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal en eliminar Ocupacion");
			ocupacionJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de eliminar()");
		return traList;
	}

	@Override
	public Ocupacion getOcupacionPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getOcupacionPorCodigo()");
		Ocupacion traList = null;

		ocupacionJPA.createEM();
		traList = ocupacionJPA.get(id);
		ocupacionJPA.releaseEM();

		log.info("Saliendo de getOcupacionPorCodigo()");

		return traList;
	}


}
