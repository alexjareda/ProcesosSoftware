package es.unican.ps.reservas.businessLayer;

import java.util.List;

import javax.ejb.Local;

import es.unican.ps.reservas.entities.*;

@Local
public interface IGestionReservasLocal {
	
	public Reserva crearReserva(Reserva r);
	public Reserva modificarReserva(Reserva v);
	public Reserva buscaReserva(int id);
	public Reserva cancelarReserva(Reserva v);
	public List<Reserva> reservas();
	public void guardaDatosCliente(String nombre, String ap1, String ap2, String email, String dni, Tarjeta t);
}
