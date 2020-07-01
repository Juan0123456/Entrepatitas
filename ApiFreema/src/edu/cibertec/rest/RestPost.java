package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import edu.cibertec.dto.LoginDTO;
import edu.cibertec.dto.TrabajadorDTO;
import edu.cibertec.entity.Trabajador;
import edu.cibertec.persistence.service.DistritoServicieImpl;
import edu.cibertec.persistence.service.OcupacionServicieImpl;
import edu.cibertec.persistence.service.TrabajadorServicieImpl;
import edu.cibertec.util.Util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Path("/post")
public class RestPost {
	
	DistritoServicieImpl distritoService = new DistritoServicieImpl();
	OcupacionServicieImpl ocupacionServicie = new OcupacionServicieImpl();
	TrabajadorServicieImpl cusService = new TrabajadorServicieImpl();
	
	static final Logger log = Logger.getLogger(RestPost.class);
	


	
	//http://localhost:8080/ApiFreema/post/login/
	
	/*
	{ 
   "login":"tr_mariaSV@gmail.com",
   "pass":"maria123"
    }
	*/
	
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String validarLogin( LoginDTO login) {
		log.info("Entrando a POST: validarLogin()");
		String result="";
		List<Trabajador> lstTrabajador = new ArrayList<Trabajador>();
		JsonObject json = new JsonObject();
		JsonElement jsonCust = null;
		TrabajadorDTO cusDTO = new TrabajadorDTO();
		try {
			lstTrabajador=cusService.getTrabajadores();
			for(Trabajador tra:lstTrabajador) {
				if(login.getCorreo().indexOf("@")==-1) {
					log.info("Logica validacion/telf");
					if(login.getCorreo().equals(""+tra.getTelefono()) && login.getContrasena().equals(tra.getContrasena())) {
						cusDTO = Util.TrabajadorJADVPAtoDTO(tra);
						jsonCust = new Gson().toJsonTree(cusDTO);
						json.add("Trabajador", jsonCust);
						json.addProperty("response", true);
						result = json.toString();
						return result;
					} 

				}else {
					log.info("Logica validacion/email");
					if(login.getCorreo().equals(tra.getCorreo()) && login.getContrasena().equals(tra.getContrasena())) {
						cusDTO = Util.TrabajadorJADVPAtoDTO(tra);
						jsonCust = new Gson().toJsonTree(cusDTO);
						json.add("Trabajador", jsonCust);
						json.addProperty("response", true);
						result = json.toString();
						return result;
					} 

				}
			}
			json.addProperty("Trabajador", "null");
			json.addProperty("response", false);
			result = json.toString();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo a POST: validarLogin()");
		return result;
	}
	
	
	
	
	
	
	

	
}
