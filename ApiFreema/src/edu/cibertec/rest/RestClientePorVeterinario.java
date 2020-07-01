package edu.cibertec.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import edu.cibertec.dto.ClienteDTO;

import edu.cibertec.persistence.jpa.dao.ClienteDAO;


@Path("/clientePorVet")
public class RestClientePorVeterinario {
	

	
	// http://localhost:8080/ApiFreema/clientePorVet/get/1
	@GET
	@Path("/get/{p_idVet}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteDTO> getClientesPorCodigoVet(@PathParam("p_idVet") int id) throws Exception {


		ClienteDAO cl = new ClienteDAO();

		List<ClienteDTO> lstClientexVet = cl.getClientesPorCodigoVet(id);

 
		return lstClientexVet;
	}
}


