package es.unican.ps.reservas.common;

import java.util.List;

/**
 * Interfaz que implementa los metodos que gestionan las reservas de un hotel
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
public interface IReservasDAO {

	public Reserva addReserva(Reserva r);
	public Reserva getReserva(int id);
	public Reserva updateReserva(Reserva r);
	public Reserva removeReserva(Reserva r);
	public List<Reserva> listReservas();
}
