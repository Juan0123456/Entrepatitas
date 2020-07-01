package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Solicitud;
import edu.cibertec.persistence.jpa.dao.SolicitudJPA;

public class SolicitudServicieImpl implements ISolicitudService{
	
	static final Logger log = Logger.getLogger(SolicitudServicieImpl.class);
	SolicitudJPA solicitudesJPA = new SolicitudJPA();
	
	@Override
	public List<Solicitud> getSolicitudes() throws Exception {
		log.info("Se ingreso a getContratosXClientes()");
		List<Solicitud> resList = null;

		solicitudesJPA.createEM();
		resList = solicitudesJPA.getAll();
		solicitudesJPA.releaseEM();

		log.info("Saliendo de getContratosXClientes()");

		return resList;
	}

	@Override
	public Solicitud getSolicitudPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getOcupacionPorCodigo()");
		Solicitud traList = null;

		solicitudesJPA.createEM();
		traList = solicitudesJPA.get(id);
		solicitudesJPA.releaseEM();

		log.info("Saliendo de getOcupacionPorCodigo()");

		return traList;
	}

	@Override
	public List<Solicitud> getSolicitudXClientes(int id) throws Exception {
		log.info("Se ingreso a getContratosXClientes()");
		List<Solicitud> resList = null;

		solicitudesJPA.createEM();
		resList = solicitudesJPA.getAllxCustomer(id);
		solicitudesJPA.releaseEM();

		log.info("Saliendo de getContratosXClientes()");

		return resList;
	}

	@Override
	public Solicitud registrar(Solicitud Solicitud) throws Exception {
log.info("Se ingreso a registrar()");
		
		try {
			solicitudesJPA.createEM();
			solicitudesJPA.beginTransaction();
			solicitudesJPA.registrar(Solicitud);
			solicitudesJPA.flush();
			solicitudesJPA.endTransaction();	
		} catch (Exception e) {
			log.error("Algo salio mal al regestrar Contrato");
			solicitudesJPA.rollbackTransaction();
			log.fatal("Exception: ",e);
		}
		
		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Solicitud eliminar(int id) throws Exception {
		log.info("Se ingreso a eliminar()");
		Solicitud traList = null;
		try {
			solicitudesJPA.createEM();
			solicitudesJPA.beginTransaction();
			traList = solicitudesJPA.get(id);
			solicitudesJPA.eliminar(traList);
			solicitudesJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal en eliminar Solicitud");
			solicitudesJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de eliminar()");
		return traList;
	}

}
