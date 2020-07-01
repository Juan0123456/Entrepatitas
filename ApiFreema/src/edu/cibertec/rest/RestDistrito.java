package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import edu.cibertec.dto.DistritoDTO;
import edu.cibertec.entity.Distrito;
import edu.cibertec.persistence.service.DistritoServicieImpl;
import edu.cibertec.util.Util;

@Path("/distrito")
public class RestDistrito {

	static final Logger log = Logger.getLogger(RestDistrito.class);
	DistritoServicieImpl distritoService = new DistritoServicieImpl();
	
	// http://localhost:8080/ApiFreema/distrito/get
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DistritoDTO> getDistritos() {
		log.info("Entro a getDistritos()");
		
		List<Distrito> lstDistJPA = new ArrayList<Distrito>();
		List<DistritoDTO> lstDist = new ArrayList<DistritoDTO>();

		try {
			lstDistJPA = distritoService.getDistritos();
			for (Distrito re : lstDistJPA) {
				lstDist.add(Util.DistritoJPAtoDTO(re));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getDistritos()");
		return lstDist;
	}
	
	
	
	
	// http://localhost:8080/ApiFreema/distrito/get/1
	
				@GET
				@Path("/get/{p_idTrab}")
				@Produces(MediaType.APPLICATION_JSON)
				public DistritoDTO listarporCodigo(@PathParam("p_idTrab") int id) {
					log.info("Entro a listarporCodigo()");
					
					Distrito lstOcuJPA = new Distrito();
					DistritoDTO lstOcu = new DistritoDTO();
					try {
						lstOcuJPA = distritoService.getDistritosPorCodigo(id);
						lstOcu = Util.DistritoJPAtoDTO(lstOcuJPA);
				
						
					} catch (Exception e) {
						// TODO: handle exception
						log.fatal("Exception: ", e);
					}
					return lstOcu;
					
					
					
				}
	
	
	
	// http://localhost:8080/ApiFreema/distrito/post/

		/*
		 * { "idDistrito":null, "nomDistrito":"Otros" }
		 */

		@POST
		@Path("/post")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Produces(MediaType.APPLICATION_JSON)
		public String registrar(DistritoDTO distritoDTO) {
			String result = "";

			Distrito distrito = new Distrito();
			distrito = Util.DistritosDTOtoJPA(distritoDTO);

			try {
				distrito = distritoService.registrar(distrito);
			} catch (Exception e) {
				log.fatal("Exception: ", e);
			}

		    result = "\"Registrado\"";

			return result;
		}
		
		
		
		
		// http://localhost:8080/ApiFreema/distrito/put/

				/*
				 * { "idDistrito":1, "nomDistrito":"Otros" }
				 */

				@PUT
				@Path("/put")
				@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
				@Produces(MediaType.APPLICATION_JSON)
				public String actualizar(DistritoDTO distritoDTO) {

					log.info("entro PUT: actualizar()");

					JsonObject json = new JsonObject();
					String result = "";

					log.info("---Empieza Insercion de Ocupacion---");

					Distrito distrito = new Distrito();
					distrito = Util.DistritosDTOtoJPA(distritoDTO);

					try {
						distrito = distritoService.actualizar(distrito);
					} catch (Exception e) {
						log.fatal("Exception: ", e);
						json.addProperty("message", "Algo salio mal al actualizar Ocupacion...");
						json.addProperty("response", false);
						result = json.toString();
						log.info("salio POST: actualizar()");
						return result;
					}
					log.info("---Finaliza insercion de Ocupacion---");

			
					result = "\"Actualizado\"";

					log.info("salio PUT: actualizar()");
					return result;
				}
		
				
				
				
				
				
				// http://localhost:8080/ApiFreema/distrito/delete/1
			
				
				@DELETE
				@Path("/delete/{p_idTrab}")
				@Produces(MediaType.APPLICATION_JSON)
				public String eliminar(@PathParam("p_idTrab") int id) {
					log.info("Entro a eliminar()");

					String result = "";		
					
					DistritoDTO distritoDTO = new DistritoDTO(); 
					
					 Util.DistritosDTOtoJPA(distritoDTO);
					
		            try {     	
		            	  distritoService.eliminar(id);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
		            
		            result = "\"Eliminado\"";
					log.info("Saliendo de eliminar()");
					
					return result;
				}
				
	

	
}
