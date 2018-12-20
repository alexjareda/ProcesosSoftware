package es.unican.ps.reservas.common;

public interface IGestionReservas {
	
	public Reserva crearReserva(Reserva r);
	public Reserva modificarReserva(Reserva v);
	public Reserva buscaReserva(int id);
	public Reserva cancelarReserva(Reserva v);
	public void guardaDatosCliente(String nombre, String ap1, String ap2, String email, String dni, Tarjeta t);
}
