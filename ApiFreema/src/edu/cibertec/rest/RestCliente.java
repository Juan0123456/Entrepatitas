package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.google.gson.JsonObject;
import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.Cliente;
import edu.cibertec.persistence.service.ClienteServicieImpl;
import edu.cibertec.util.Util;

@Path("/cliente")
public class RestCliente {

	static final Logger log = Logger.getLogger(RestCliente.class);
	ClienteServicieImpl clienteServicie = new ClienteServicieImpl();

	// http://localhost:8080/ApiFreema/cliente/get

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteDTO> getClientes() {
		log.info("Entro a getClientes()");

		List<Cliente> lstCliJPA = new ArrayList<Cliente>();
		List<ClienteDTO> lstCli = new ArrayList<ClienteDTO>();

		try {
			lstCliJPA = clienteServicie.getClientes();
			for (Cliente re : lstCliJPA) {
				lstCli.add(Util.ClienteJPAtoDTO(re));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getClientes()");
		return lstCli;
	}

	// http://localhost:8080/ApiFreema/cliente/get/100

	@GET
	@Path("/get/{p_idCli}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO getClientesPorCodigo(@PathParam("p_idCli") int id) {
		log.info("Entro a getClientesPorCodigo()");

		Cliente lstCliJPA = new Cliente();
		ClienteDTO lstCli = new ClienteDTO();

		try {
			lstCliJPA = clienteServicie.getClientesPorCodigo(id);

			lstCli = Util.ClienteJPAtoDTO(lstCliJPA);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getClientesPorCodigo()");
		return lstCli;
	}

	// http://localhost:8080/ApiFreema/cliente/post

	/*
	  { "idCliente":999, "nombreCli":"Juan", "apePatCli":"Salazar",
	  "apeMatCli":"Cartolin", "direccionCli":"VillaMaria",
	  "fecNacCli":"1999-02-09", "correoCli":"juan@hotmail.com",
	  "dniCli":"12345678", "nombreFotoCli":"juan.jpg",
	  "idDistrito":{"idDistrito":1,"nomDistrito":"LIMA"}, "contrasena":"juan123"}
	 */

	@POST
	@Path("/post")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public String registrar(ClienteDTO clienteDTO) {

		log.info("entro POST: registroDistrito()");

		JsonObject json = new JsonObject();
		String result = "";

		log.info("---Empieza Insercion de Ocupacion---");

		Cliente cliente = new Cliente();
		cliente = Util.ClienteDTOtoJPA(clienteDTO);

		try {
			cliente = clienteServicie.registrar(cliente);
		} catch (Exception e) {
			log.fatal("Exception: ", e);
			json.addProperty("message", "Algo salio mal al registrar Ocupacion...");
			json.addProperty("response", false);
			result = json.toString();
			log.info("salio POST: registroOcupacion()");
			return result;
		}
		log.info("---Finaliza insercion de Ocupacion---");

		result = "\"Registrado\"";

		log.info("salio POST: registroOcupacion()");
		return result;
	}

	// http://localhost:8080/ApiFreema/cliente/put/

	/*
	 * { "idCliente":100, "nombreCli":"Actualizado", "apePatCli":"Salazar",
	 * "apeMatCli":"Cartolin", "direccionCli":"VillaMaria",
	 * "fecNacCli":"1999-02-09", "correoCli":"juan@hotmail.com",
	 * "dniCli":"12345678", "nombreFotoCli":"juan.jpg",
	 * "idDistrito":{"idDistrito":1,"nomDistrito":"LIMA"}, "contrasena":"juan123"}
	 */

	@PUT
	@Path("/put")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizar(ClienteDTO clienteDTO) {

		log.info("entro PUT: actualizar()");

		String result = "";

		Cliente cliente = new Cliente();
		cliente = Util.ClienteDTOtoJPA(clienteDTO);

		try {
			cliente = clienteServicie.actualizar(cliente);
		} catch (Exception e) {
			log.fatal("Exception: ", e);

			log.info("salio POST: actualizar()");
			return result;
		}

		result = "\"Actualizado\"";

		return result;
	}

}
