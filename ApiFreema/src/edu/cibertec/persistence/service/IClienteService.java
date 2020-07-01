package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.Cliente;



public interface IClienteService {

	public Cliente getCliente(Integer id) throws Exception;
	public List<Cliente> getClientes() throws Exception;
	public Cliente getClientesPorCodigo(int id)	throws Exception;
	public Cliente registrar(Cliente Cliente) throws Exception;
	public Cliente actualizar(Cliente Cliente) throws Exception;
	public void eliminar(Integer id) throws Exception;
	
	public List<ClienteDTO> getClientesPorCodigoVet(int id)	throws Exception;

}
