package edu.cibertec.persistence.jpa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Ocupacion;

public class OcupacionJPA extends GenericoJPA{
	
	private static final long serialVersionUID = 1L;
	
	public Ocupacion get(Integer id) throws Exception{
		return em.find(Ocupacion.class, id);
	}
	
	public List<Ocupacion> getAll() throws Exception {
		TypedQuery<Ocupacion> query = em.createQuery("FROM Ocupacion ORDER BY idTecnico DESC",Ocupacion.class);
		return query.getResultList();
	}
	
	
	public Ocupacion getAllxOcupacion(int id) throws Exception {
		TypedQuery<Ocupacion> query = em.createQuery("FROM Ocupacion where idTecnico = ?1",Ocupacion.class);
		query.setParameter(1, id);
		return query.getSingleResult();
	}
	
	public void registrar(Ocupacion OcupacionJPA) throws Exception{
		em.persist(OcupacionJPA);
	}
	
	
	public void actualizar(Ocupacion OcupacionJPA) throws Exception{
		em.merge(OcupacionJPA);
	}
	
	
	public void eliminar(Ocupacion OcupacionJPA) throws Exception{
		em.remove(OcupacionJPA);
	}

}
