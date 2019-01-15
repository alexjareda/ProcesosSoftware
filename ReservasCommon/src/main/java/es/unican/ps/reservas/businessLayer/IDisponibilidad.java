package es.unican.ps.reservas.businessLayer;

import java.util.Date;

import es.unican.ps.reservas.entities.Hotel;

public interface IDisponibilidad {

	public Hotel buscaHotelNombre(String nombre);
	public Hotel buscaHotelLocalidad(String localidad);
	public boolean consultaDisponibilidad(Hotel h, Date ini, Date fin);
}
