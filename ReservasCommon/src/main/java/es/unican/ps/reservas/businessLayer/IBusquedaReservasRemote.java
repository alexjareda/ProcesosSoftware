package es.unican.ps.reservas.businessLayer;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import es.unican.ps.reservas.entities.Hotel;
import es.unican.ps.reservas.entities.Reserva;

@Remote
public interface IBusquedaReservasRemote {

	public Reserva buscaReserva(int id);
	public List<Reserva> mostrarReservasHotel(Hotel h);
	public List<Reserva> mostrarReservasFecha(Date ini, Date fin);
	public List<Reserva> mostrarReservasHotelFecha(Hotel h, Date ini, Date fin);
}
