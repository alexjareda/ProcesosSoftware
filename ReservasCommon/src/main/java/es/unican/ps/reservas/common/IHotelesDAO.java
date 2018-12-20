package es.unican.ps.reservas.common;

import java.util.List;

/**
 * Interfaz que implementa los metodos que gestionan los hoteles de la aplicacion
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
public interface IHotelesDAO {

	public Hotel addHotel(Hotel h);
	public Hotel getHotel(String nombre);
	public Hotel updateHotel(Hotel h);
	public Hotel removeHotel(Hotel h);
	public List<Hotel> listHoteles();
}


