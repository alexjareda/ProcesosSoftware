package es.unican.ps.reservas.businessLayer.implementacion;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import es.unican.ps.reservas.businessLayer.IDisponibilidadLocal;
import es.unican.ps.reservas.businessLayer.IDisponibilidadRemote;
import es.unican.ps.reservas.businessLayer.IGestionHotelesLocal;
import es.unican.ps.reservas.businessLayer.IGestionHotelesRemote;
import es.unican.ps.reservas.daoLayer.IHotelesDAORemote;
import es.unican.ps.reservas.daoLayer.IReservasDAORemote;
import es.unican.ps.reservas.entities.*;



public class GestionHoteles implements IDisponibilidadLocal, IDisponibilidadRemote, IGestionHotelesLocal, IGestionHotelesRemote{

	@EJB
	private IHotelesDAORemote hoteles;

	@EJB
	private IReservasDAORemote reservas;



	/**
	 * Metodo que anhade un tipo de habitacion a un hotel concreto
	 */
	public TipoHabitacion anhadirTipoHabitacion(Hotel h, TipoHabitacion t) {
		Hotel hot = hoteles.getHotel(h.getNombre());
		if(hot != null){
			boolean flag = hot.getHabitaciones().contains(t);
			if(!flag){
				hot.getHabitaciones().add(t);
				return t;
			}
		}
		return null;
	}

	/**
	 * Metodo que cambia la disponibilidad de un tipo de habitaciones de un hotel
	 */
	public boolean cambiarDisponibilidadHabitaciones(Hotel h, TipoHabitacion t, int reservadas) {
		Hotel hot = hoteles.getHotel(h.getNombre());
		if(hot != null){
			for(TipoHabitacion tipos : hot.getHabitaciones()){
				if(tipos.getId() == t.getId()){
					t.setDisponibles(t.getDisponibles() - reservadas);
				}
			}
		}
		return false;
	}

	/**
	 * Metodo que devuelve un hotel buscado por su nombre
	 */
	public Hotel buscaHotelNombre(String nombre) {
		Hotel h = hoteles.getHotel(nombre);
		if(h != null)
			return h;
		return null;
	}

	/**
	 * Metodo que devuelve los hoteles segun la localidad
	 */
	public List<Hotel> buscaHotelLocalidad(String localidad) {
		List<Hotel> listaHoteles = hoteles.getHotelLocalidad(localidad);
		if(listaHoteles != null)
			return listaHoteles;
		return null;
	}

	/**
	 * Metodo que devuelve un boolean indicando si el hotel tiene disponibilidad en las fechas indicadas
	 */
	public boolean consultaDisponibilidad(Hotel h, Date ini, Date fin) {
		Hotel hot = hoteles.getHotel(h.getNombre());
		if(hot != null){
			//Para cada tipo de habitacion compruebo si hay hab disponibles
			for(TipoHabitacion tipo: hot.getHabitaciones()){
				//Numero de habitaciones reservadas por cada tipo de habitacion
				int habitaciones = 0;
				//Tomamos todas las reservas del hotel
				for(Reserva r : hot.getReservas()){
					//Para cada reserva, cogemos las reservas por tipo de habitacion
					for(ReservaTipoHabitacion rth: r.getLista()){
						//Cogemos solo las reservas del tipo de habitacion que estamos comprobando
						if(rth.getTipoHabitacion().equals(tipo)){
							//Si las fechas de reserva es anterior o durante, se suman las hab ocupadas 
							if((r.getFechaEntrada().before(ini) && r.getFechaSalida().after(fin)) ||
									r.getFechaEntrada().before(ini) && r.getFechaSalida().before(fin) ||
									r.getFechaEntrada().after(ini) && r.getFechaSalida().before(fin)){
								habitaciones += rth.getHabitaciones();
							}
						}
					}
					//Si hay hab disponibles, terminamos de mirar, hay disponibilidad en el hotel
					if(tipo.getDisponibles() > habitaciones){
						return true;
					}
				}
			}
		}
		return false;
	}
}
