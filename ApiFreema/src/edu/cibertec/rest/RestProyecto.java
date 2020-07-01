package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import edu.cibertec.dto.ProyectoDTO;

import edu.cibertec.entity.Proyecto;

import edu.cibertec.persistence.service.ProyectoServicieImpl;
import edu.cibertec.util.Util;

@Path("/proyecto")
public class RestProyecto {

	
static final Logger log = Logger.getLogger(RestProyecto.class);
	
	ProyectoServicieImpl proyectoService = new ProyectoServicieImpl();
	
	// http://localhost:8080/ApiFreema/proyecto/get
	
			@GET
			@Path("/get/{p_idTrab}")
			@Produces(MediaType.APPLICATION_JSON)
			public List<ProyectoDTO> getProyectos(@PathParam("p_idTrab") int id) {
				log.info("Entro a getProyectos()");
				
				List<Proyecto> lstTrabJPA = new ArrayList<Proyecto>();
				List<ProyectoDTO> lstTrab = new ArrayList<ProyectoDTO>();

				try {
					lstTrabJPA = proyectoService.getProyectos(id);
					for (Proyecto re : lstTrabJPA) {
						lstTrab.add(Util.ProyectoJPAtoDTO(re));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getProyectos()");
				return lstTrab;
			}
			
			
			
			// http://localhost:8080/ApiFreema/proyecto/post/

						/*
			            *{
			            "idProyecto": 1,
			            "nomProyecto": "Nuevo",
			            "fechInicio": "2020-05-11",
			            "fechFin": "2020-06-10",
			            "idTrab": {
            "idTrab": 1,
            "nombreTrab": "Maria",
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
			            }
						*/

						
						@POST
						@Path("/post")
						@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
						@Produces(MediaType.APPLICATION_JSON)
						public String registrar(ProyectoDTO proyectoDTO) {

							log.info("entro POST: registroDistrito()");

							JsonObject json = new JsonObject();
							String result = "";
							
							log.info("---Empieza Insercion de Ocupacion---");

							Proyecto proyecto = new Proyecto();
							proyecto = Util.ProyectoDTOtoJPA(proyectoDTO);

							try {
								proyecto = proyectoService.registrar(proyecto);
							} catch (Exception e) {
								log.fatal("Exception: ", e);
								json.addProperty("message", "Algo salio mal al registrar Proyecto...");
								json.addProperty("response", false);
								result = json.toString();
								log.info("salio POST: registroProyecto()");
								return result;
							}

						    result = "\"Registrado\"";

							return result;
						}
			
			
		
	
}
