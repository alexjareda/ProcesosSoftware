package es.unican.ps.reservas.businessLayer.implementacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import es.unican.ps.reservas.businessLayer.IBusquedaReservasLocal;
import es.unican.ps.reservas.businessLayer.IBusquedaReservasRemote;
import es.unican.ps.reservas.businessLayer.IGestionReservasLocal;
import es.unican.ps.reservas.businessLayer.IGestionReservasRemote;
import es.unican.ps.reservas.daoLayer.IHotelesDAORemote;
import es.unican.ps.reservas.daoLayer.IReservasDAORemote;
import es.unican.ps.reservas.entities.*;



public class GestionReservas implements IGestionReservasLocal, IGestionReservasRemote, IBusquedaReservasLocal, 
IBusquedaReservasRemote{

	@EJB
	private IHotelesDAORemote hoteles;

	@EJB
	private IReservasDAORemote reservas;


	/**
	 * Metodo que devuelve la lista de reservas del hotel h
	 */
	public List<Reserva> mostrarReservasHotel(Hotel h) {
		Hotel hotel = hoteles.getHotel(h.getNombre());
		if(hotel != null){
			return hotel.getReservas();
		}
		return null;
	}

	/**
	 * Metodo que muestra las reservas durante una fecha determinada (fecha de entrada + fecha de salida)
	 */
	public List<Reserva> mostrarReservasFecha(Date ini, Date fin) {
		List<Reserva> lista = new ArrayList<Reserva>();

		for(Reserva r: reservas.listReservas()){
			if((r.getFechaEntrada().equals(ini)) && (r.getFechaSalida().equals(fin))){
				lista.add(r);
			}
		}
		if(lista.isEmpty())
			lista=null;

		return lista;
	}

	/**
	 * Metodo que devuelve las reservas en un hotel en unas fechas concretas
	 */
	public List<Reserva> mostrarReservasHotelFecha(Hotel h, Date ini, Date fin) {
		List<Reserva> lista = new ArrayList<Reserva>();
		Hotel hotel = hoteles.getHotel(h.getNombre());

		if(hotel != null){
			for(Reserva r: h.getReservas()){
				if((r.getFechaEntrada().equals(ini)) && (r.getFechaSalida().equals(fin))){
					lista.add(r);
				}
			}
		} else {
			return null;
		}
		if(lista.isEmpty())
			lista=null;

		return lista;
	}

	/**
	 * Metodo que crea una reserva en un determinado hotel
	 */
	public Reserva crearReserva(Reserva r) {
		Reserva res = reservas.getReserva(r.getId());

		if(res == null){
			reservas.addReserva(r);
			return r;
		}
		return null;
	}

	/**
	 * Metodo que modificada una reserva
	 */
	public Reserva modificarReserva(Reserva v) {
		Reserva res = reservas.getReserva(v.getId());

		if(res != null){
			reservas.updateReserva(v);
			return v;
		}
		return null;
	}

	/**
	 * Metodo que devuelve la reserva indicada mediante el id
	 */
	public Reserva buscaReserva(int id) {
		for(Reserva r: reservas.listReservas()){
			if(r.getId() == id){
				return r;
			}
		}
		return null;
	}

	/**
	 * Metodo que borra la reserva indicada
	 */
	public Reserva cancelarReserva(Reserva v) {
		for(Reserva r: reservas.listReservas()){
			if(r.equals(v)){
				reservas.listReservas().remove(v);
				return v;
			}
		}
		return null;
	}

	/**
	 * Metodo que devuelve todas las reservas 
	 */
	public List<Reserva> reservas() {
		return reservas.listReservas();
	}

	public void guardaDatosCliente(String nombre, String ap1, String ap2, String email, String dni, Tarjeta t) {

		//No se implementa la parte de los usuarios

	}
}
