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
		if(em.find(Hotel.class, h.getNombre())== null){
			em.persist(h);
			return h;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Hotel getHotel(String nombre) {
		Query q = em.createQuery("SELECT h FROM Hoteles h WHERE h.getNombre() = :nombre");
		q.setParameter("nombre", nombre);
		List<Hotel> lista = q.getResultList();
		Hotel buscado = lista.get(0);
		if (buscado != null)
			return buscado;
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Hotel> getHotelLocalidad(String loc) {
		Query q = em.createQuery("SELECT h FROM Hoteles h WHERE h.getLocalidad() = :loc");
		q.setParameter("loc", loc);
		List<Hotel> lista = q.getResultList();
		if (lista != null)
			return lista;
		return null;
	}

	public Hotel updateHotel(Hotel h) {
		if(em.find(Hotel.class, h.getNombre())== null){
			em.merge(h);
			return h;
		}
		return null;	
	}

	public Hotel removeHotel(Hotel h) {
		if(em.find(Hotel.class, h.getNombre())== null){
			Hotel devolver = h;
			em.remove(h);
			return devolver;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> listHoteles() {
		Query q = em.createQuery("SELECT a FROM Hotel a");
		return (List<Hotel>) q.getResultList();
	}

}
