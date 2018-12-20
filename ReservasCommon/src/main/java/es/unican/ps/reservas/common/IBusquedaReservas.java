package es.unican.ps.reservas.common;

import java.util.Date;
import java.util.List;

public interface IBusquedaReservas {

	public Reserva buscaReserva(int id);
	public List<Reserva> mostrarReservasHotel(Hotel h);
	public List<Reserva> mostrarReservasFecha(Date ini, Date fin);
	public List<Reserva> mostrarReservasHotelFecha(Hotel h, Date ini, Date fin);
}
