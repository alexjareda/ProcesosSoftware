package es.unican.ps.reservas.common;

import java.util.Date;

public interface IDisponibilidad {

	public Hotel buscaHotelNombre(String nombre);
	public Hotel buscaHotelLocalidad(String localidad);
	public boolean consultaDisponibilidad(Hotel h, Date ini, Date fin);
}
