package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.Cliente;
import edu.cibertec.persistence.jpa.dao.ClienteJPA;

public class ClienteServicieImpl implements IClienteService{

	static final Logger log = Logger.getLogger(ClienteServicieImpl.class);
	ClienteJPA cliJPA = new ClienteJPA();
	
	@Override
	public Cliente getCliente(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getClientes() throws Exception {
		log.info("Se ingreso a getClientes()");
		List<Cliente> lstCli = new ArrayList<Cliente>();
		cliJPA.createEM();
		lstCli = cliJPA.getAll();
		cliJPA.releaseEM();
		log.info("Se salio de getClientes()");
		return lstCli;
	}

	@Override
	public Cliente registrar(Cliente Cliente) throws Exception {
		log.info("Se ingreso a registrar()");

		try {
			cliJPA.createEM();
			cliJPA.beginTransaction();
			cliJPA.registrar(Cliente);
			cliJPA.flush();
			cliJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al registrar Cliente");
			cliJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}

		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Cliente actualizar(Cliente Cliente) throws Exception {
		log.info("Se ingreso a actualizar()");

		try {
			cliJPA.createEM();
			cliJPA.beginTransaction();
			cliJPA.actualizar(Cliente);
			cliJPA.flush();
			cliJPA.endTransaction();
		} catch (Exception e) {
			log.error("Algo salio mal al actualizar Ocupacion");
			cliJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Ocupacion actualizado");
		log.info("Se salio de actualizar()");
		return Cliente;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente getClientesPorCodigo(int id) throws Exception {
		log.info("Se ingreso a getClientesPorCodigo()");
		Cliente cliList = null;

		cliJPA.createEM();
		cliList = cliJPA.get(id);
		cliJPA.releaseEM();

		log.info("Saliendo de getClientesPorCodigo()");

		return cliList;
	}

	@Override
	public List<ClienteDTO> getClientesPorCodigoVet(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
