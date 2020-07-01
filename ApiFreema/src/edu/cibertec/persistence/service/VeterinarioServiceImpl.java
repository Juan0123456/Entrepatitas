package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Veterinario;
import edu.cibertec.persistence.jpa.dao.VeterinarioJPA;

public class VeterinarioServiceImpl implements IVeterinarioService{

	static final Logger log = Logger.getLogger(VeterinarioServiceImpl.class);
	VeterinarioJPA vetJPA = new VeterinarioJPA();
	
	@Override
	public Veterinario getVeterinario(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veterinario> getVeterinarios() throws Exception {
		log.info("Se ingreso a getVeterinarios()");
		List<Veterinario> lstVet = new ArrayList<Veterinario>();
		vetJPA.createEM();
		lstVet = vetJPA.getAll();
		vetJPA.releaseEM();
		log.info("Se salio de getVeterinarios()");
		return lstVet;
	}

	@Override
	public Veterinario getVeterinarioPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getVeterinarioPorCodigo()");
		Veterinario vetList = null;

		vetJPA.createEM();
		vetList = vetJPA.get(id);
		vetJPA.releaseEM();

		log.info("Saliendo de getVeterinarioPorCodigo()");

		return vetList;
	}

	@Override
	public List<Veterinario> getVeterinarioPorDistrito(int id) throws Exception {
		log.info("Se ingreso a getVeterinarioPorDistrito()");
		List<Veterinario> vetList = null;

		vetJPA.createEM();
		vetList = vetJPA.VeterinariosPorDistrito(id);
		vetJPA.releaseEM();

		log.info("Saliendo de getVeterinarioPorDistrito()");

		return vetList;
	}

	@Override
	public Veterinario registrar(Veterinario Veterinario) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			vetJPA.createEM();
			vetJPA.beginTransaction();
			vetJPA.registrar(Veterinario);
			vetJPA.flush();
			vetJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Contrato");
			vetJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Veterinario actualizar(Veterinario Veterinario) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			vetJPA.createEM();
			vetJPA.beginTransaction();
			vetJPA.actualizar(Veterinario);	
			vetJPA.flush();
			vetJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Veterinario");
			vetJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Veterinario;
	}

	@Override
	public Veterinario login(String correo, String contrasena) {
		log.info("Se ingreso a login()");
		return null;
	}

}
