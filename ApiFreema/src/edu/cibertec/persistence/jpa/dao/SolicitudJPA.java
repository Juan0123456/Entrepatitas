package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Solicitud;

public class SolicitudJPA extends GenericoJPA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Solicitud get(Integer id) throws Exception{
		return em.find(Solicitud.class, id);
	}
	
	
	public List<Solicitud> getAll() throws Exception {
		TypedQuery<Solicitud> query = em.createQuery("FROM Solicitud ORDER BY idsolicitud DESC",Solicitud.class);
		return query.getResultList();
	}
	
	
	
	public List<Solicitud> getAllxCustomer(int id) throws Exception {
		TypedQuery<Solicitud> query = em.createQuery("FROM Solicitud where idVet = ?1",Solicitud.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public void registrar(Solicitud SolicitudJPA) throws Exception{
		em.persist(SolicitudJPA);
	}
	
	public void eliminar(Solicitud SolicitudJPA) throws Exception{
		em.remove(SolicitudJPA);
	}
	

}
