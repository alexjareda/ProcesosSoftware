package es.unican.ps.reservas.daoLayer;

import java.util.List;

import es.unican.ps.reservas.entities.Hotel;

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
	public List<Hotel> getHotelLocalidad(String loc);
	
	public List<Hotel> listHoteles();
}


