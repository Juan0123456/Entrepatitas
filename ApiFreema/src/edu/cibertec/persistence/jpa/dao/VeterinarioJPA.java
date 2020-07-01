package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Veterinario;

public class VeterinarioJPA extends GenericoJPA{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Veterinario get(Integer id) throws Exception{
		return em.find(Veterinario.class, id);
	}
	
	
	public List<Veterinario> getAll() throws Exception {
		TypedQuery<Veterinario> query = em.createQuery("FROM Veterinario ORDER BY idVet DESC",Veterinario.class);
		return query.getResultList();
	}
	
	public List<Veterinario> getAllxVeterinario(int id) throws Exception {
		TypedQuery<Veterinario> query = em.createQuery("FROM Veterinario where idVet = ?1",Veterinario.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public List<Veterinario> VeterinariosPorDistrito(int id) throws Exception {
		TypedQuery<Veterinario> query = em.createQuery("FROM Veterinario where idDistrito = ?1",Veterinario.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public void registrar(Veterinario VeterinarioJPA) throws Exception{
		em.persist(VeterinarioJPA);
	}
	
	
	public void actualizar(Veterinario VeterinarioJPA) throws Exception{
		em.merge(VeterinarioJPA);
	}
	

}
