package es.unican.ps.daoLayer.implementacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.reservas.daoLayer.IHotelesDAOLocal;
import es.unican.ps.reservas.daoLayer.IHotelesDAORemote;
import es.unican.ps.reservas.entities.Hotel;


@Stateless
public class HotelesDAO implements IHotelesDAOLocal, IHotelesDAORemote{


	@PersistenceContext(unitName="CentralReservasPU")
	private EntityManager em;



	public Hotel addHotel(Hotel h) {
		em.persist(h);
		return h;
	}

	public Hotel getHotel(String nombre) {
		return em.find(Hotel.class, nombre);
	}

	public Hotel updateHotel(Hotel h) {
		return em.merge(h);
	}

	public Hotel removeHotel(Hotel h) {
		Hotel devolver = em.merge(h); 
		em.remove(h);
		return devolver;
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> listHoteles() {
		Query q = em.createQuery("SELECT a FROM Hotel a");
		return (List<Hotel>) q.getResultList();
	}

}
