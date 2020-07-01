package edu.cibertec.util;

import org.apache.log4j.Logger;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.dto.ContratoDTO;
import edu.cibertec.dto.DistritoDTO;
import edu.cibertec.dto.OcupacionDTO;
import edu.cibertec.dto.ProyectoDTO;
import edu.cibertec.dto.ServicioDTO;
import edu.cibertec.dto.SolicitudDTO;
import edu.cibertec.dto.TrabajadorDTO;
import edu.cibertec.dto.VeterinarioDTO;
import edu.cibertec.entity.Cliente;
import edu.cibertec.entity.Contrato;
import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Ocupacion;
import edu.cibertec.entity.Proyecto;
import edu.cibertec.entity.Servicio;
import edu.cibertec.entity.Solicitud;
import edu.cibertec.entity.Trabajador;
import edu.cibertec.entity.Veterinario;

public class Util {

	static final Logger log = Logger.getLogger(Util.class);

	public static DistritoDTO DistritoJPAtoDTO(Distrito dis) {
		DistritoDTO dto = new DistritoDTO();

		dto.setIdDistrito(dis.getIdDistrito());
		dto.setNomDistrito(dis.getNomDistrito());

		log.info("Id:        " + dto.getIdDistrito());
		log.info("Nombre:      " + dto.getNomDistrito());

		return dto;
	}

	public static OcupacionDTO OcupacionJPAtoDTO(Ocupacion ocu) {
		OcupacionDTO dto = new OcupacionDTO();

		dto.setIdTecnico(ocu.getIdTecnico());
		dto.setNomTecnico(ocu.getNomTecnico());

		log.info("Id:        " + dto.getIdTecnico());
		log.info("Nombre:      " + dto.getNomTecnico());

		return dto;
	}

	
	
	public static Distrito DistritosDTOtoJPA(DistritoDTO dis) {
		Distrito dto = new Distrito();

		dto.setIdDistrito(dis.getIdDistrito());
		dto.setNomDistrito(dis.getNomDistrito());

		log.info("Id:        " + dto.getIdDistrito());
		log.info("Nombre:      " + dto.getNomDistrito());

		return dto;
	}
	
	
	public static Ocupacion OcupacionesDTOtoJPA(OcupacionDTO ocu) {
		Ocupacion dto = new Ocupacion();

		dto.setIdTecnico(ocu.getIdTecnico());
		dto.setNomTecnico(ocu.getNomTecnico());

		log.info("Id:        " + dto.getIdTecnico());
		log.info("Nombre:      " + dto.getNomTecnico());

		return dto;
	}
	
	
	public static Trabajador TrabajadorDTOtoJPA(TrabajadorDTO tra) {
		Trabajador dto = new Trabajador();

		dto.setIdTrab(tra.getIdTrab());
		dto.setNombreTrab(tra.getNombreTrab());
		dto.setApePatTrab(tra.getApePatTrab());
		dto.setApeMatTrab(tra.getApeMatTrab());
		dto.setRuc(tra.getRuc());
		dto.setDni(tra.getDni());
		dto.setTelefono(tra.getTelefono());
		dto.setCorreo(tra.getCorreo());
		dto.setDireccion(tra.getDireccion());
		dto.setNombreimg(tra.getNombreimg());
		dto.setIdDistrito(Util.DistritosDTOtoJPA(tra.getIdDistrito()));
		dto.setIdTecnico(Util.OcupacionesDTOtoJPA(tra.getIdTecnico()));
		dto.setContrasena(tra.getContrasena());

		log.info("ID Trabajador: " + tra.getIdTrab());
		log.info("Nombre:" + tra.getNombreTrab());

		return dto;
	}
	
	public static Veterinario VeterinarioDTOtoJPA(VeterinarioDTO vet) {
		Veterinario dto = new Veterinario();

		dto.setIdVet(vet.getIdVet());
		dto.setNombreVet(vet.getNombreVet());
		dto.setApePatVet(vet.getApePatVet());
		dto.setApeMatVet(vet.getApeMatVet());
		dto.setRuc(vet.getRuc());
		dto.setDni(vet.getDni());
		dto.setTelefono(vet.getTelefono());
		dto.setCorreo(vet.getCorreo());
		dto.setDireccion(vet.getDireccion());
		dto.setNombreimg(vet.getNombreimg());
		dto.setIdDistrito(Util.DistritosDTOtoJPA(vet.getIdDistrito()));
		dto.setContrasena(vet.getContrasena());

		log.info("ID Veterinario: " + vet.getIdVet());
		log.info("Nombre:" + vet.getNombreVet());

		return dto;
	}
	
	
	
	public static Cliente ClienteDTOtoJPA(ClienteDTO cli) {
		Cliente dto = new Cliente();

		dto.setIdCliente(cli.getIdCliente());
		dto.setNombreCli(cli.getNombreCli());
		dto.setApePatCli(cli.getApePatCli());
		dto.setApeMatCli(cli.getApeMatCli());
		dto.setDireccionCli(cli.getDireccionCli());
		dto.setFecNacCli(cli.getFecNacCli());
		dto.setCorreoCli(cli.getCorreoCli());
		dto.setDniCli(cli.getDniCli());
		dto.setNombreFotoCli(cli.getNombreCli());
		dto.setIdDistrito(Util.DistritosDTOtoJPA(cli.getIdDistrito()));
		dto.setContrasena(cli.getContrasena());
		

		log.info("ID: " + cli.getIdCliente());
		log.info("DES:" + cli.getNombreCli());

		return dto;
	}
	
	
	
	public static Contrato ContratoDTOtoJPA(ContratoDTO cont) {
		Contrato dto = new Contrato();

		dto.setIdcontrato(cont.getIdcontrato());
		dto.setFecha(cont.getFecha());
		dto.setDescripcion(cont.getDescripcion());
		dto.setIdCliente(Util.ClienteDTOtoJPA(cont.getIdCliente()));
		dto.setIdVet(Util.VeterinarioDTOtoJPA(cont.getIdVet()));

		log.info("" + cont.getIdcontrato());
		log.info("" + cont.getDescripcion());

		return dto;
	}
	
	

	public static ClienteDTO ClienteJPAtoDTO(Cliente cli) {
		ClienteDTO dto = new ClienteDTO();

		dto.setIdCliente(cli.getIdCliente());
		dto.setNombreCli(cli.getNombreCli());
		dto.setApePatCli(cli.getApePatCli());
		dto.setApeMatCli(cli.getApeMatCli());
		dto.setDireccionCli(cli.getDireccionCli());
		dto.setFecNacCli(cli.getFecNacCli());
		dto.setCorreoCli(cli.getCorreoCli());
		dto.setDniCli(cli.getDniCli());
		dto.setNombreFotoCli(cli.getNombreCli());
		dto.setIdDistrito(Util.DistritoJPAtoDTO(cli.getIdDistrito()));
		dto.setContrasena(cli.getContrasena());
		

		log.info("ID: " + cli.getIdCliente());
		log.info("DES:" + cli.getNombreCli());

		return dto;
	}
	
	

	public static TrabajadorDTO TrabajadorJADVPAtoDTO(Trabajador tra) {
		TrabajadorDTO dto = new TrabajadorDTO();

		dto.setIdTrab(tra.getIdTrab());
		dto.setNombreTrab(tra.getNombreTrab());
		dto.setApePatTrab(tra.getApePatTrab());
		dto.setApeMatTrab(tra.getApeMatTrab());
		dto.setRuc(tra.getRuc());
		dto.setDni(tra.getDni());
		dto.setTelefono(tra.getTelefono());
		dto.setCorreo(tra.getCorreo());
		dto.setDireccion(tra.getDireccion());
		dto.setNombreimg(tra.getNombreimg());
		dto.setIdDistrito(Util.DistritoJPAtoDTO(tra.getIdDistrito()));
		dto.setIdTecnico(Util.OcupacionJPAtoDTO(tra.getIdTecnico()));
		dto.setContrasena(tra.getContrasena());

		log.info("ID: " + tra.getIdTrab());
		log.info("DES:" + tra.getNombreTrab());

		return dto;
	}
	
	public static VeterinarioDTO VeterinarioJPAtoDTO(Veterinario vet) {
		VeterinarioDTO dto = new VeterinarioDTO();

		dto.setIdVet(vet.getIdVet());
		dto.setNombreVet(vet.getNombreVet());
		dto.setApePatVet(vet.getApePatVet());
		dto.setApeMatVet(vet.getApeMatVet());
		dto.setRuc(vet.getRuc());
		dto.setDni(vet.getDni());
		dto.setTelefono(vet.getTelefono());
		dto.setCorreo(vet.getCorreo());
		dto.setDireccion(vet.getDireccion());
		dto.setNombreimg(vet.getNombreimg());
		dto.setIdDistrito(Util.DistritoJPAtoDTO(vet.getIdDistrito()));
		dto.setContrasena(vet.getContrasena());

		log.info("ID: " + vet.getIdVet());
		log.info("DES:" + vet.getNombreVet());

		return dto;
	}
	

	
	

	public static ContratoDTO ContratoJPAtoDTO(Contrato cont) {
		ContratoDTO dto = new ContratoDTO();

		dto.setIdcontrato(cont.getIdcontrato());
		dto.setFecha(cont.getFecha());
		dto.setDescripcion(cont.getDescripcion());
		dto.setIdCliente(Util.ClienteJPAtoDTO(cont.getIdCliente()));
		dto.setIdVet(Util.VeterinarioJPAtoDTO(cont.getIdVet()));

		log.info("" + cont.getIdcontrato());
		log.info("" + cont.getDescripcion());

		return dto;
	}
	
	
	
	
	public static ProyectoDTO ProyectoJPAtoDTO(Proyecto cont) {
		ProyectoDTO dto = new ProyectoDTO();

		dto.setIdProyecto(cont.getIdProyecto());
		dto.setNomProyecto(cont.getNomProyecto());
		dto.setFechInicio(cont.getFechFin());
		dto.setFechFin(cont.getFechInicio());
		dto.setRucEmpresa(cont.getRucEmpresa());
		dto.setIdTrab(Util.TrabajadorJADVPAtoDTO(cont.getIdTrab()));

		
		log.info("" + cont.getIdProyecto());
		log.info("" + cont.getNomProyecto());

		return dto;
	}
	
	public static Proyecto ProyectoDTOtoJPA(ProyectoDTO cont) {
		Proyecto dto = new Proyecto();

		dto.setIdProyecto(cont.getIdProyecto());
		dto.setNomProyecto(cont.getNomProyecto());
		dto.setFechInicio(cont.getFechFin());
		dto.setFechFin(cont.getFechInicio());
		dto.setRucEmpresa(cont.getRucEmpresa());
		dto.setIdTrab(Util.TrabajadorDTOtoJPA(cont.getIdTrab()));

		
		log.info("" + cont.getIdProyecto());
		log.info("" + cont.getNomProyecto());

		return dto;
	}
	
	public static ServicioDTO ServicioJPAtoDTO(Servicio cont) {
		ServicioDTO dto = new ServicioDTO();

		dto.setIdServicio(cont.getIdServicio());
		dto.setNomServicio(cont.getNomServicio());
		dto.setCostoServicio(cont.getCostoServicio());
		dto.setIdVet(cont.getIdVet());
		
		
		log.info("" + cont.getIdServicio());
		log.info("" + cont.getNomServicio());

		return dto;
	}
	
	public static Servicio ServicioDTOtoJPA(ServicioDTO cont) {
		Servicio dto = new Servicio();
		
		dto.setIdServicio(cont.getIdServicio());
		dto.setNomServicio(cont.getNomServicio());
		dto.setCostoServicio(cont.getCostoServicio());
		dto.setIdVet(cont.getIdVet());

		
		log.info("" + cont.getIdServicio());
		log.info("" + cont.getNomServicio());

		return dto;
	}
	public static Solicitud SolicitudDTOtoJPA(SolicitudDTO cont) {
		Solicitud dto = new Solicitud();

		dto.setIdsolicitud(cont.getIdsolicitud());
		dto.setFecha(cont.getFecha());
		dto.setDescripcion(cont.getDescripcion());
		dto.setIdVet(cont.getIdVet());
		
		

		log.info("" + cont.getIdsolicitud());
		log.info("" + cont.getDescripcion());

		return dto;
	}
	
	public static SolicitudDTO SolicitudJPAtoDTO(Solicitud cont) {
		SolicitudDTO dto = new SolicitudDTO();

		dto.setIdsolicitud(cont.getIdsolicitud());
		dto.setFecha(cont.getFecha());
		dto.setDescripcion(cont.getDescripcion());
		dto.setIdVet(cont.getIdVet());

		log.info("" + cont.getIdsolicitud());
		log.info("" + cont.getDescripcion());
		
		return dto;
	}
	
	

}
