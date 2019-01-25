package es.unican.ps.reservas.businessLayer;

import java.util.List;

import javax.ejb.Remote;

import es.unican.ps.reservas.entities.Reserva;
import es.unican.ps.reservas.entities.Tarjeta;

@Remote
public interface IGestionReservasRemote {

	public Reserva crearReserva(Reserva r);
	public Reserva modificarReserva(Reserva v);
	public Reserva buscaReserva(int id);
	public Reserva cancelarReserva(Reserva v);
	public List<Reserva> reservas();
	public void guardaDatosCliente(String nombre, String ap1, String ap2, String email, String dni, Tarjeta t);
}
