package es.unican.ps.reservas.businessLayer;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import es.unican.ps.reservas.entities.Hotel;

@Remote
public interface IDisponibilidadRemote {

	public Hotel buscaHotelNombre(String nombre);
	public List<Hotel> buscaHotelLocalidad(String localidad);
	public boolean consultaDisponibilidad(Hotel h, Date ini, Date fin);
}
