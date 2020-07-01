package edu.cibertec.persistence.service;


import java.util.List;
import org.apache.log4j.Logger;
import edu.cibertec.entity.Contrato;
import edu.cibertec.persistence.jpa.dao.ContratoJPA;

public class ContratoServicieImpl implements IContratoService{

	
	static final Logger log = Logger.getLogger(ContratoServicieImpl.class);
	ContratoJPA contratosJPA = new ContratoJPA();
	
	
	

	
	
	@Override
	public List<Contrato> getContratos() throws Exception {
		log.info("Se ingreso a getContratosXClientes()");
		List<Contrato> resList = null;

		contratosJPA.createEM();
		resList = contratosJPA.getAll();
		contratosJPA.releaseEM();

		log.info("Saliendo de getContratosXClientes()");

		return resList;
	}
	
	
	@Override
	public List<Contrato> getContratosXClientes(int id) throws Exception {
		log.info("Se ingreso a getContratosXClientes()");
		List<Contrato> resList = null;

		contratosJPA.createEM();
		resList = contratosJPA.getAllxCustomer(id);
		contratosJPA.releaseEM();

		log.info("Saliendo de getContratosXClientes()");

		return resList;
	}

	@Override
	public Contrato registrar(Contrato Contrato) throws Exception {
	log.info("Se ingreso a registrar()");
		
		try {
			contratosJPA.createEM();
			contratosJPA.beginTransaction();
			contratosJPA.registrar(Contrato);
			contratosJPA.flush();
			contratosJPA.endTransaction();	
		} catch (Exception e) {
			log.error("Algo salio mal al regestrar Contrato");
			contratosJPA.rollbackTransaction();
			log.fatal("Exception: ",e);
		}
		
		log.info("Se salio de registrar()");
		return null;
	}


	@Override
	public Contrato getContratosPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getOcupacionPorCodigo()");
		Contrato traList = null;

		contratosJPA.createEM();
		traList = contratosJPA.get(id);
		contratosJPA.releaseEM();

		log.info("Saliendo de getOcupacionPorCodigo()");

		return traList;
	}


	

}
