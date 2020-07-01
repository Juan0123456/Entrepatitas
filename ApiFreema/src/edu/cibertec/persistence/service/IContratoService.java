package edu.cibertec.persistence.service;

import java.util.List;
import edu.cibertec.entity.Contrato;

public interface IContratoService {
	
	
	public List<Contrato> getContratos() throws Exception;
	public Contrato getContratosPorCodigo(int id)	throws Exception;
	public List<Contrato> getContratosXClientes(int id)	throws Exception;
	public Contrato registrar(Contrato Contrato) throws Exception;

}
