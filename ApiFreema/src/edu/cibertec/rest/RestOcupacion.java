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
import edu.cibertec.dto.OcupacionDTO;
import edu.cibertec.entity.Ocupacion;
import edu.cibertec.persistence.service.OcupacionServicieImpl;
import edu.cibertec.util.Util;

@Path("/ocupacion")
public class RestOcupacion {

	static final Logger log = Logger.getLogger(RestOcupacion.class);

	OcupacionServicieImpl ocupacionService = new OcupacionServicieImpl();

	
	
	
	
	// http://localhost:8080/ApiFreema/ocupacion/get

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OcupacionDTO> listar() {
		log.info("Entro a getOcupacion()");

		List<Ocupacion> lstOcuJPA = new ArrayList<Ocupacion>();
		List<OcupacionDTO> lstOcu = new ArrayList<OcupacionDTO>();

		try {
			lstOcuJPA = ocupacionService.getOcupaciones();
			for (Ocupacion re : lstOcuJPA) {
				lstOcu.add(Util.OcupacionJPAtoDTO(re));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getOcupacion()");
		return lstOcu;
	}
	

	
	
	// http://localhost:8080/ApiFreema/ocupacion/get/1
	
			@GET
			@Path("/get/{p_idTrab}")
			@Produces(MediaType.APPLICATION_JSON)
			public OcupacionDTO listarporCodigo(@PathParam("p_idTrab") int id) {
				log.info("Entro a listarporCodigo()");
				
				Ocupacion lstOcuJPA = new Ocupacion();
				OcupacionDTO lstOcu = new OcupacionDTO();
				try {
					lstOcuJPA = ocupacionService.getOcupacionPorCodigo(id);
					lstOcu = Util.OcupacionJPAtoDTO(lstOcuJPA);
			
					
				} catch (Exception e) {
					// TODO: handle exception
					log.fatal("Exception: ", e);
				}
				return lstOcu;
				
				
				
			}
	
	
	

	

	// http://localhost:8080/ApiFreema/ocupacion/post/

	/*
	 * { "idTecnico":null, "nomTecnico":"Otros" }
	 */

	@POST
	@Path("/post")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public String registrar(OcupacionDTO ocupacionDTO) {

		log.info("entro POST: registroDistrito()");

		JsonObject json = new JsonObject();
		String result = "";

		log.info("---Empieza Insercion de Ocupacion---");

		Ocupacion ocupacion = new Ocupacion();
		ocupacion = Util.OcupacionesDTOtoJPA(ocupacionDTO);

		try {
			ocupacion = ocupacionService.registrar(ocupacion);
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
	
	
	
	
	
	
	// http://localhost:8080/ApiFreema/ocupacion/put/

		/*
		 * { "idTecnico":27, "nomTecnico":"Otros" }
		 */

		@PUT
		@Path("/put")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Produces(MediaType.APPLICATION_JSON)
		public String actualizar(OcupacionDTO ocupacionDTO) {

			log.info("entro PUT: actualizar()");

			JsonObject json = new JsonObject();
			String result = "";

			log.info("---Empieza Insercion de Ocupacion---");

			Ocupacion ocupacion = new Ocupacion();
			ocupacion = Util.OcupacionesDTOtoJPA(ocupacionDTO);

			try {
				ocupacion = ocupacionService.actualizar(ocupacion);
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
	
		
		
		
		// http://localhost:8080/ApiFreema/ocupacion/delete/1
	
		
		@DELETE
		@Path("/delete/{p_idTrab}")
		@Produces(MediaType.APPLICATION_JSON)
		public String eliminar(@PathParam("p_idTrab") int id) {
			log.info("Entro a eliminar()");

			String result = "";		
			
			OcupacionDTO ocupacionDTO = new OcupacionDTO(); 
			
			 Util.OcupacionesDTOtoJPA(ocupacionDTO);
			
            try {     	
            	  ocupacionService.eliminar(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
            
            result = "\"Eliminado\"";
			log.info("Saliendo de eliminar()");
			
			return result;
		}
		
		
	
	

}
