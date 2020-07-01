package edu.cibertec.persistence.jpa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Distrito;


public class DistritoJPA extends GenericoJPA{

	
	private static final long serialVersionUID = 1L;
	
	public Distrito get(Integer id) throws Exception{
		return em.find(Distrito.class, id);
	}
	
	public List<Distrito> getAll() throws Exception {
		TypedQuery<Distrito> query = em.createQuery("FROM Distrito ORDER BY nomDistrito ASC",Distrito.class);
		return query.getResultList();
	}
	
	public void registrar(Distrito DistritoJPA) throws Exception{
		em.persist(DistritoJPA);
	}
	
	public void actualizar(Distrito DistritoJPA) throws Exception{
		em.merge(DistritoJPA);
	}
	
	
	public void eliminar(Distrito DistritoJPA) throws Exception{
		em.remove(DistritoJPA);
	}

	
	
	
}
