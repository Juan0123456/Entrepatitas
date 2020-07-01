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
import edu.cibertec.dto.TrabajadorDTO;
import edu.cibertec.entity.Trabajador;
import edu.cibertec.persistence.service.TrabajadorServicieImpl;
import edu.cibertec.util.Util;

@Path("/trabajador")
public class RestTrabajador {
	
	static final Logger log = Logger.getLogger(RestTrabajador.class);
	
	TrabajadorServicieImpl trabajadorService = new TrabajadorServicieImpl();
	
	// http://localhost:8080/ApiFreema/trabajador/get
	
			@GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public List<TrabajadorDTO> getTrabajadores() {
				log.info("Entro a getTrabajadores()");
				
				List<Trabajador> lstTrabJPA = new ArrayList<Trabajador>();
				List<TrabajadorDTO> lstTrab = new ArrayList<TrabajadorDTO>();

				try {
					lstTrabJPA = trabajadorService.getTrabajadores();
					for (Trabajador re : lstTrabJPA) {
						lstTrab.add(Util.TrabajadorJADVPAtoDTO(re));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getTrabajadores()");
				return lstTrab;
			}
		
			

			// http://localhost:8080/ApiFreema/trabajador/get/1
			
			@GET
			@Path("/get/{p_idTrab}")
			@Produces(MediaType.APPLICATION_JSON)
			public TrabajadorDTO getTrabajadoresPorCodigo(@PathParam("p_idTrab") int id) {
				log.info("Entro a getTrabajadoresPorCodigo()");
				
				Trabajador lstTrabJPA = new Trabajador();
				TrabajadorDTO lstTrab = new TrabajadorDTO();

				try {
					lstTrabJPA = trabajadorService.getTrabajadorPorCodigo(id);
                    lstTrab = Util.TrabajadorJADVPAtoDTO(lstTrabJPA);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getTrabajadoresPorCodigo()");
				return lstTrab;
			}
			
			
			
			
			
			
			// http://localhost:8080/ApiFreema/trabajador/post/

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
			public String registrar(TrabajadorDTO trabajadorDTO) {

				log.info("entro POST: registroDistrito()");

				JsonObject json = new JsonObject();
				String result = "";
				
				log.info("---Empieza Insercion de Ocupacion---");

				Trabajador trabajador = new Trabajador();
				trabajador = Util.TrabajadorDTOtoJPA(trabajadorDTO);

				try {
					trabajador = trabajadorService.registrar(trabajador);
				} catch (Exception e) {
					log.fatal("Exception: ", e);
					json.addProperty("message", "Algo salio mal al registrar Ocupacion...");
					json.addProperty("response", false);
					result = json.toString();
					log.info("salio POST: registroOcupacion()");
					return result;
				}

			    result = "\"Registrado\"";

				return result;
			}
			
			
			
			
			
			
			// http://localhost:8080/ApiFreema/trabajador/carrera/1
			
			@GET
			@Path("/carrera/{p_idTrab}")
			@Produces(MediaType.APPLICATION_JSON)
			public List<TrabajadorDTO> getTrabajadoresPorCarrera(@PathParam("p_idTrab") int id) {
				log.info("Entro a getTrabajadoresPorCarrera()");
				
				List<Trabajador> lstTrabJPA = new ArrayList<Trabajador>();
				List<TrabajadorDTO> lstTrab = new ArrayList<TrabajadorDTO>();

				try {
					lstTrabJPA = trabajadorService.getTrabajadorPorCarrera(id);
					for (Trabajador re : lstTrabJPA) {
						lstTrab.add(Util.TrabajadorJADVPAtoDTO(re));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.fatal("Exception: ", e);
				}

				log.info("Saliendo de getTrabajadoresPorCarrera()");
				return lstTrab;
			}
			

			
			
			
			// http://localhost:8080/ApiFreema/trabajador/put/

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
			public String actualizar(TrabajadorDTO trabajadorDTO) {

				log.info("entro PUT: actualizar()");

				JsonObject json = new JsonObject();
				String result = "";

				log.info("---Empieza Insercion de Ocupacion---");

				Trabajador trabajador = new Trabajador();
				trabajador = Util.TrabajadorDTOtoJPA(trabajadorDTO);

				try {
					trabajador = trabajadorService.actualizar(trabajador);
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
			
	
	
	
}
