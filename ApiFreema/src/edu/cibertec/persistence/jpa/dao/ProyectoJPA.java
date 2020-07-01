package edu.cibertec.persistence.jpa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Proyecto;
import edu.cibertec.entity.Trabajador;



public class ProyectoJPA extends GenericoJPA{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Proyecto> getAll(int id) throws Exception {
		TypedQuery<Proyecto> query = em.createQuery("FROM Proyecto where idTrab = ?1",Proyecto.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public void registrar(Proyecto ProyectoJPA) throws Exception{
		em.persist(ProyectoJPA);
	}
	
	
}
