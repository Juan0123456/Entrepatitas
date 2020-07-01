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
import edu.cibertec.dto.ServicioDTO;
import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Servicio;
import edu.cibertec.persistence.service.ServicioServiceImpl;
import edu.cibertec.util.Util;

@Path("/servicio")
public class RestServicio {
	static final Logger log = Logger.getLogger(RestServicio.class);
	ServicioServiceImpl servicioService = new ServicioServiceImpl();
	
	
	
	
	// http://localhost:8080/ApiFreema/servicio/get/1
	
	@GET
	@Path("/getServicio/{p_idServicio}")
	@Produces(MediaType.APPLICATION_JSON)
	public ServicioDTO listarporCodigo(@PathParam("p_idServicio") int id) {
		log.info("Entro a listarporCodigo()");
		
		Servicio lstOcuJPA = new Servicio();
		ServicioDTO lstOcu = new ServicioDTO();
		try {
			lstOcuJPA = servicioService.getServiciosPorCodigo(id);
			lstOcu = Util.ServicioJPAtoDTO(lstOcuJPA);
	
			
		} catch (Exception e) {
			// TODO: handle exception
			log.fatal("Exception: ", e);
		}
		return lstOcu;
		
		
	}
	
	// http://localhost:8080/ApiFreema/servicio/get/
	
				@GET
				@Path("/get/{p_idServicio}")
				@Produces(MediaType.APPLICATION_JSON)
				public List<ServicioDTO> getServicios(@PathParam("p_idServicio") int id) {
					log.info("Entro a getServicios()");
					
					List<Servicio> lstVetJPA = new ArrayList<Servicio>();
					List<ServicioDTO> lstVet = new ArrayList<ServicioDTO>();

					try {
						lstVetJPA = servicioService.getServicios(id);
						for (Servicio re : lstVetJPA) {
							lstVet.add(Util.ServicioJPAtoDTO(re));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.fatal("Exception: ", e);
					}

					log.info("Saliendo de getProyectos()");
					return lstVet;
				}
				
				// http://localhost:8080/ApiFreema/servicio/getVeterinario/1
				
				@GET
				@Path("/getVeterinario/{p_idVet}")
				@Produces(MediaType.APPLICATION_JSON)
				public List<ServicioDTO> geServiciosXVeterinario(@PathParam("p_idVet") int id) {
					log.info("Entro a getContratosxCliente()");
					List<Servicio> lstContJPA = new ArrayList<Servicio>();
					List<ServicioDTO> lstCont = new ArrayList<ServicioDTO>();

					try {
						lstContJPA = servicioService.getServiciosXVeterinario(id);
						for (Servicio re : lstContJPA) {
							lstCont.add(Util.ServicioJPAtoDTO(re));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.fatal("Exception: ", e);
					}

					log.info("Saliendo de getContratosxCliente()");
					return lstCont;
				}
				
				// http://localhost:8080/ApiFreema/servicio/post/

							/*
				            *{
				            "idServicio": 1,
				            "nomServicio": "Consulta",
				            "costoServicio": 0.0,
				            "idVet": 1
				            }
							*/

							
							@POST
							@Path("/post")
							@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
							@Produces(MediaType.APPLICATION_JSON)
							public String registrar(ServicioDTO servicioDTO) {

								log.info("entro POST: registroDistrito()");

								JsonObject json = new JsonObject();
								String result = "";
								
								log.info("---Empieza Insercion de Ocupacion---");

								Servicio servicio = new Servicio();
								servicio = Util.ServicioDTOtoJPA(servicioDTO);

								try {
									servicio = servicioService.registrar(servicio);
								} catch (Exception e) {
									log.fatal("Exception: ", e);
									json.addProperty("message", "Algo salio mal al registrar el Servicio...");
									json.addProperty("response", false);
									result = json.toString();
									log.info("salio POST: registroProyecto()");
									return result;
								}

							    result = "\"Registrado\"";

								return result;
							}
							
							
							
							// http://localhost:8080/ApiFreema/servicio/delete/1
							
							
							@DELETE
							@Path("/delete/{p_idServicio}")
							@Produces(MediaType.APPLICATION_JSON)
							public String eliminar(@PathParam("p_idServicio") int id) {
								log.info("Entro a eliminar()");

								String result = "";		
								
								ServicioDTO servicioDTO = new ServicioDTO(); 
								
								 Util.ServicioDTOtoJPA(servicioDTO);
								
					            try {     	
					            	  servicioService.eliminar(id);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}		
					            
					            result = "\"Eliminado\"";
								log.info("Saliendo de eliminar()");
								
								return result;
							}
							
							
							// http://localhost:8080/ApiFreema/servicio/put/

							/*
							 
				            *{
				            "idServicio": 1,
				            "nomServicio": "Consulta",
				            "costoServicio": 0.0,
				            "idVet": 1
				            }
							*/
							 

							@PUT
							@Path("/put")
							@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
							@Produces(MediaType.APPLICATION_JSON)
							public String actualizar(ServicioDTO servicioDTO) {

								log.info("entro PUT: actualizar()");

								JsonObject json = new JsonObject();
								String result = "";

								log.info("---Empieza Insercion de Ocupacion---");

								Servicio servicio = new Servicio();
								servicio = Util.ServicioDTOtoJPA(servicioDTO);

								try {
									servicio = servicioService.actualizar(servicio);
								} catch (Exception e) {
									log.fatal("Exception: ", e);
									json.addProperty("message", "Algo salio mal al actualizar Servicio...");
									json.addProperty("response", false);
									result = json.toString();
									log.info("salio POST: actualizar()");
									return result;
								}
								log.info("---Finaliza insercion de Servicio---");

						
								result = "\"Actualizado\"";

								log.info("salio PUT: actualizar()");
								return result;
							}
							
							
							
				
	
	
	
	
}
