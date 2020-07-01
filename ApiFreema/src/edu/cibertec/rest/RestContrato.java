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
import edu.cibertec.dto.ContratoDTO;
import edu.cibertec.entity.Contrato;
import edu.cibertec.persistence.service.ContratoServicieImpl;
import edu.cibertec.util.Util;


@Path("/contrato")
public class RestContrato {

	static final Logger log = Logger.getLogger(RestContrato.class);
	ContratoServicieImpl contratoService = new ContratoServicieImpl();
	
	
	
	// http://localhost:8080/ApiFreema/contrato/get
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContratoDTO> getContratos() {
		log.info("Entro a getContratos()");
		List<Contrato> lstContJPA = new ArrayList<Contrato>();
		List<ContratoDTO> lstCont = new ArrayList<ContratoDTO>();

		try {
			lstContJPA = contratoService.getContratos();
			for (Contrato re : lstContJPA) {
				lstCont.add(Util.ContratoJPAtoDTO(re));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getContratosxCliente()");
		return lstCont;
	}
	
	
	
	
	
	
	
	// http://localhost:8080/ApiFreema/contrato/get/1
	
		@GET
		@Path("/get/{p_idCust}")
		@Produces(MediaType.APPLICATION_JSON)
		public ContratoDTO getContratosxCodigo(@PathParam("p_idCust") int id) {
			log.info("Entro a getContratosxCodigo()");
			
			Contrato lstOcuJPA = new Contrato();
			ContratoDTO lstOcu = new ContratoDTO();
			try {
				lstOcuJPA = contratoService.getContratosPorCodigo(id);
				lstOcu = Util.ContratoJPAtoDTO(lstOcuJPA);
		
				
			} catch (Exception e) {
				// TODO: handle exception
				log.fatal("Exception: ", e);
			}
			return lstOcu;
		}
		
	
	
	
	
	// http://localhost:8080/ApiFreema/contrato/getCliente/101
	
	@GET
	@Path("/getCliente/{p_idCust}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContratoDTO> getContratosxCliente(@PathParam("p_idCust") int id) {
		log.info("Entro a getContratosxCliente()");
		List<Contrato> lstContJPA = new ArrayList<Contrato>();
		List<ContratoDTO> lstCont = new ArrayList<ContratoDTO>();

		try {
			lstContJPA = contratoService.getContratosXClientes(id);
			for (Contrato re : lstContJPA) {
				lstCont.add(Util.ContratoJPAtoDTO(re));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal("Exception: ", e);
		}

		log.info("Saliendo de getContratosxCliente()");
		return lstCont;
	}
	
	
	// http://localhost:8080/ApiFreema/contrato/post/
	
	/*{
        "idcontrato": 1,
        "fecha": "15/06/2020",
        "descripcion": "Baño",
        "idCliente": "1",
        "idVet": "21"
        }
	*/
	
	@POST
	@Path("/post")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public String registrar(ContratoDTO contratoDTO) {
		String result = "";

		Contrato contrato = new Contrato();
		contrato = Util.ContratoDTOtoJPA(contratoDTO);

		try {
			contrato = contratoService.registrar(contrato);
		} catch (Exception e) {
			log.fatal("Exception: ", e);
		}

	    result = "\"Registrado\"";

		return result;
	}
	
	
	
	
	
}
