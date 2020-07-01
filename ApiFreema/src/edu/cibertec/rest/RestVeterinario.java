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
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import edu.cibertec.dto.LoginDTO;
import edu.cibertec.dto.VeterinarioDTO;
import edu.cibertec.entity.Veterinario;
import edu.cibertec.persistence.jpa.dao.VeterinarioDAO;
import edu.cibertec.persistence.service.VeterinarioServiceImpl;
import edu.cibertec.util.Util;

@Path("/veterinario")
public class RestVeterinario {
static final Logger log = Logger.getLogger(RestVeterinario.class);
	
	VeterinarioServiceImpl veterinarioService = new VeterinarioServiceImpl();
	
	// http://localhost:8080/ApiFreema/veterinario/get
	
			@GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public List<VeterinarioDTO> getVeterinarios() {
				log.info("Entro a getVeterinarios()");
				
				List<Veterinario> lstVetJPA = new ArrayList<Veterinario>();
				List<VeterinarioDTO> lstVet = new ArrayList<VeterinarioDTO>();

				try {
					lstVetJPA = veterinarioService.getVeterinarios();
					for (Veterinario re : lstVetJPA) {
						lstVet.add(Util.VeterinarioJPAtoDTO(re));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getTrabajadores()");
				return lstVet;
			}
		
			

			// http://localhost:8080/ApiFreema/veterinario/get/1
			
			@GET
			@Path("/get/{p_idVet}")
			@Produces(MediaType.APPLICATION_JSON)
			public VeterinarioDTO getVeterinariosPorCodigo(@PathParam("p_idVet") int id) {
				log.info("Entro a getVeterinariosPorCodigo()");
				
				Veterinario lstVetJPA = new Veterinario();
				VeterinarioDTO lstVet = new VeterinarioDTO();

				try {
					lstVetJPA = veterinarioService.getVeterinarioPorCodigo(id);
					lstVet = Util.VeterinarioJPAtoDTO(lstVetJPA);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getVeterinariosPorCodigo()");
				return lstVet;
			}
			
			
			
			
			
			
			// http://localhost:8080/ApiFreema/veterinario/post/

			/*
            *{
            "idTrab": 999,
            "nombreTrab": "Nuevo",
            "apePatTrab": "Sara",
            "apeMatTrab": "Vargas",
            "ruc": "12345678910",
            "dni": 40414243,
            "telefono": 1234567,
            "correo": "tr_mariaSV@gmail.com",
            "direccion": "c. Tacama",
            "nombreimg": null,
            "idDistrito": {
            "idDistrito": 10,
            "nomDistrito": "COMAS"
            },
            "idTecnico": {
            "idTecnico": 1,
            "nomTecnico": "Administracion de Empresas"
            },
            "contrasena": "maria123"
            }
			*/

			
			@POST
			@Path("/post")
			@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
			@Produces(MediaType.APPLICATION_JSON)
			public String registrar(VeterinarioDTO veterinarioDTO) {

				log.info("entro POST: registroVeterinario()");

				JsonObject json = new JsonObject();
				String result = "";
				
				log.info("---Empieza Insercion de Ocupacion---");

				Veterinario veterinario = new Veterinario();
				veterinario = Util.VeterinarioDTOtoJPA(veterinarioDTO);

				try {
					veterinario = veterinarioService.registrar(veterinario);
				} catch (Exception e) {
					log.fatal("Exception: ", e);
					json.addProperty("message", "Algo salio mal al registrar Veterinario...");
					json.addProperty("response", false);
					result = json.toString();
					log.info("salio POST: registroVeterinario()");
					return result;
				}

			    result = "\"Registrado\"";

				return result;
			}
			
			
			
			
			
			
			// http://localhost:8080/ApiFreema/veterinario/distrito/1
			
			@GET
			@Path("/distrito/{p_idVet}")
			@Produces(MediaType.APPLICATION_JSON)
			public List<VeterinarioDTO> getVeterinarioPorDistrito(@PathParam("p_idVet") int id) {
				log.info("Entro a getVeterinarioPorDistrito()");
				
				List<Veterinario> lstVetJPA = new ArrayList<Veterinario>();
				List<VeterinarioDTO> lstVet = new ArrayList<VeterinarioDTO>();

				try {
					lstVetJPA = veterinarioService.getVeterinarioPorDistrito(id);
					for (Veterinario re : lstVetJPA) {
						lstVet.add(Util.VeterinarioJPAtoDTO(re));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getVeterinarioPorDistrito()");
				return lstVet;
			}
			

			
			
			
			// http://localhost:8080/ApiFreema/veterinario/put/

			/*
			 {
            "idTrab": 1,
            "nombreTrab": "Nuevo",
            "apePatTrab": "Sara",
            "apeMatTrab": "Vargas",
            "ruc": "12345678910",
            "dni": 40414243,
            "telefono": 1234567,
            "correo": "tr_mariaSV@gmail.com",
            "direccion": "c. Tacama",
            "nombreimg": null,
            "idDistrito": {
            "idDistrito": 10,
            "nomDistrito": "COMAS"
            },
            "idTecnico": {
            "idTecnico": 1,
            "nomTecnico": "Administracion de Empresas"
            },
            "contrasena": "maria123"
            }
			 */

			@PUT
			@Path("/put")
			@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
			@Produces(MediaType.APPLICATION_JSON)
			public String actualizar(VeterinarioDTO veterinarioDTO) {

				log.info("entro PUT: actualizar()");

				JsonObject json = new JsonObject();
				String result = "";

				log.info("---Empieza Actualización de Veterinario---");

				Veterinario veterinario = new Veterinario();
				veterinario = Util.VeterinarioDTOtoJPA(veterinarioDTO);

				try {
					veterinario = veterinarioService.actualizar(veterinario);
				} catch (Exception e) {
					log.fatal("Exception: ", e);
					json.addProperty("message", "Algo salio mal al actualizar Veterinario...");
					json.addProperty("response", false);
					result = json.toString();
					log.info("salio POST: actualizar()");
					return result;
				}
				log.info("---Finaliza insercion de Veterinario---");

		
				result = "\"Actualizado\"";

				log.info("salio PUT: actualizar()");
				return result;
			}
			
			
			
			
			//http://localhost:8080/ApiFreema/veterinario/login	
			//	JSON PARA LOGIN post
			//	{
			//	   		"correo": "tr_mariaSV@gmail.com",
			//	 		"contrasena": "maria123"
			//	}
			@POST
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			@Path("/login")
			public Response loginCliente(LoginDTO lr) {
				VeterinarioDAO usuDAO = new VeterinarioDAO();
				
				return Response.status(Response.Status.CREATED).entity(usuDAO.login(lr.getCorreo(), lr.getContrasena())).build();
			}
			
}
