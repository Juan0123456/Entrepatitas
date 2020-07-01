package edu.cibertec.persistence.service;

import java.util.List;


import edu.cibertec.entity.Veterinario;

public interface IVeterinarioService {

	public Veterinario getVeterinario(Integer id) throws Exception;
	public List<Veterinario> getVeterinarios()	throws Exception;
	public Veterinario getVeterinarioPorCodigo(int id)	throws Exception;
	public List<Veterinario> getVeterinarioPorDistrito(int id)	throws Exception;
	public Veterinario registrar(Veterinario Veterinario) throws Exception;
	public Veterinario	actualizar(Veterinario Veterinario) throws Exception;
	
	
	public Veterinario login(String correo, String contrasena);
}
