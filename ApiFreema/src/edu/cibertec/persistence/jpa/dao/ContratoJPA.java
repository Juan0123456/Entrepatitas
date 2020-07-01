package edu.cibertec.persistence.jpa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Contrato;

public class ContratoJPA extends GenericoJPA{
	

	private static final long serialVersionUID = 1L;

	
	public Contrato get(Integer id) throws Exception{
		return em.find(Contrato.class, id);
	}
	
	
	public List<Contrato> getAll() throws Exception {
		TypedQuery<Contrato> query = em.createQuery("FROM Contrato ORDER BY idcontrato DESC",Contrato.class);
		return query.getResultList();
	}
	
	
	
	public List<Contrato> getAllxCustomer(int id) throws Exception {
		TypedQuery<Contrato> query = em.createQuery("FROM Contrato where idCliente = ?1",Contrato.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public void registrar(Contrato ContratoJPA) throws Exception{
		em.persist(ContratoJPA);
	}


}
