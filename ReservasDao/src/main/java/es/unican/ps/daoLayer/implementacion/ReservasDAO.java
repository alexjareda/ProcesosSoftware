package es.unican.ps.daoLayer.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.reservas.daoLayer.IReservasDAOLocal;
import es.unican.ps.reservas.daoLayer.IReservasDAORemote;
import es.unican.ps.reservas.entities.Reserva;

public class ReservasDAO implements IReservasDAOLocal, IReservasDAORemote{


	@PersistenceContext(unitName="CentralReservasPU")
	private EntityManager em;




	public Reserva addReserva(Reserva r) {
		em.persist(r);
		return r;
	}

	public Reserva getReserva(int id) {
		return em.find(Reserva.class, id);
	}

	public Reserva updateReserva(Reserva r) {
		return em.merge(r);
	}

	public Reserva removeReserva(Reserva r) {
		Reserva devolver = em.merge(r); 
		em.remove(r);
		return devolver;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> listReservas() {
		Query q = em.createQuery("SELECT a FROM Reserva a");
		return (List<Reserva>) q.getResultList();
	}

}
