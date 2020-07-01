package edu.cibertec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import edu.cibertec.dto.SolicitudDTO;
import edu.cibertec.entity.Solicitud;
import edu.cibertec.persistence.service.SolicitudServicieImpl;
import edu.cibertec.util.Util;

@Path("/solicitud")
public class RestSolicitud {
	
	static final Logger log = Logger.getLogger(RestContrato.class);
	SolicitudServicieImpl solicitudService = new SolicitudServicieImpl();
	
	// http://localhost:8080/ApiFreema/contrato/get
	
		@GET
		@Path("/get")
		@Produces(MediaType.APPLICATION_JSON)
		public List<SolicitudDTO> getContratos() {
			log.info("Entro a getContratos()");
			List<Solicitud> lstContJPA = new ArrayList<Solicitud>();
			List<SolicitudDTO> lstCont = new ArrayList<SolicitudDTO>();

			try {
				lstContJPA = solicitudService.getSolicitudes();
				for (Solicitud re : lstContJPA) {
					lstCont.add(Util.SolicitudJPAtoDTO(re));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.fatal("Exception: ", e);
			}

			log.info("Saliendo de getContratosxCliente()");
			return lstCont;
		}
		
		
		
		
		
		
		
		// http://localhost:8080/ApiFreema/solicitud/get/1
		
			@GET
			@Path("/get/{p_idCust}")
			@Produces(MediaType.APPLICATION_JSON)
			public SolicitudDTO getContratosxCodigo(@PathParam("p_idCust") int id) {
				log.info("Entro a getSolicitudesxCodigo()");
				
				Solicitud lstOcuJPA = new Solicitud();
				SolicitudDTO lstOcu = new SolicitudDTO();
				try {
					lstOcuJPA = solicitudService.getSolicitudPorCodigo(id);
					lstOcu = Util.SolicitudJPAtoDTO(lstOcuJPA);
			
					
				} catch (Exception e) {
					// TODO: handle exception
					log.fatal("Exception: ", e);
				}
				return lstOcu;
			}
			
		
		
		
		
		// http://localhost:8080/ApiFreema/solicitud/getVet/1
		
		@GET
		@Path("/getVet/{p_idVet}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<SolicitudDTO> getSolicitudxCliente(@PathParam("p_idVet") int id) {
			log.info("Entro a getContratosxCliente()");
			List<Solicitud> lstContJPA = new ArrayList<Solicitud>();
			List<SolicitudDTO> lstCont = new ArrayList<SolicitudDTO>();

			try {
				lstContJPA = solicitudService.getSolicitudXClientes(id);
				for (Solicitud re : lstContJPA) {
					lstCont.add(Util.SolicitudJPAtoDTO(re));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.fatal("Exception: ", e);
			}

			log.info("Saliendo de getSolicitudesxVeterinario()");
			return lstCont;
		}
		
		
		// http://localhost:8080/ApiFreema/solicitud/post/
		
		/*{
	        "idsolicitud": 1,
	        "fecha": "2000/01/01",
	        "descripcion": "Baño",
	        "idVet": 1
	        }
		*/
		
		@POST
		@Path("/post")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Produces(MediaType.APPLICATION_JSON)
		public String registrar(SolicitudDTO solicitudDTO) {
			String result = "";

			Solicitud solicitud = new Solicitud();
			solicitud = Util.SolicitudDTOtoJPA(solicitudDTO);

			try {
				solicitud = solicitudService.registrar(solicitud);
			} catch (Exception e) {
				log.fatal("Exception: ", e);
			}

		    result = "\"Registrado\"";

			return result;
		}
		
		
		
		
		// http://localhost:8080/ApiFreema/solicitud/delete/1
		
		
		@DELETE
		@Path("/delete/{p_idSolicitud}")
		@Produces(MediaType.APPLICATION_JSON)
		public String eliminar(@PathParam("p_idSolicitud") int id) {
			log.info("Entro a eliminar()");

			String result = "";		
			
			SolicitudDTO solicitudDTO = new SolicitudDTO(); 
			
			 Util.SolicitudDTOtoJPA(solicitudDTO);
			
            try {     	
            	  solicitudService.eliminar(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
            
            result = "\"Eliminado\"";
			log.info("Saliendo de eliminar()");
			
			return result;
		}
		
		
		
}
