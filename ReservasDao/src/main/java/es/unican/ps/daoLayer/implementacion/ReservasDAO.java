package es.unican.ps.daoLayer.implementacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.reservas.daoLayer.IReservasDAOLocal;
import es.unican.ps.reservas.daoLayer.IReservasDAORemote;
import es.unican.ps.reservas.entities.Reserva;

@Stateless
public class ReservasDAO implements IReservasDAOLocal, IReservasDAORemote{


	@PersistenceContext(unitName="CentralReservasPU")
	private EntityManager em;


	public Reserva addReserva(Reserva r) {
		if(em.find(Reserva.class, r.getId()) == null){
			em.persist(r);
			return r;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Reserva getReserva(Long id) {
		Query q = em.createQuery("SELECT r FROM Reservas r WHERE r.getId() = :id");
		q.setParameter("id", id);
		List<Reserva> lista = q.getResultList();
		Reserva buscada = lista.get(0);
		if (buscada != null)
			return buscada;
		return null;
	}

	public Reserva updateReserva(Reserva r) {
		if(em.find(Reserva.class, r.getId()) == null){
			em.merge(r);
			return r;
		}
		return null;
	}

	public Reserva removeReserva(Reserva r) {
		if(em.find(Reserva.class, r.getId()) == null){
			Reserva devolver = em.merge(r); 
			em.remove(r);
			return devolver;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> listReservas() {
		Query q = em.createQuery("SELECT a FROM Reserva a");
		return (List<Reserva>) q.getResultList();
	}

}
