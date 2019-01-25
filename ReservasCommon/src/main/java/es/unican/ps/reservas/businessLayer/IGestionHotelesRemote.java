package es.unican.ps.reservas.businessLayer;

import javax.ejb.Remote;

import es.unican.ps.reservas.entities.Hotel;
import es.unican.ps.reservas.entities.TipoHabitacion;

@Remote
public interface IGestionHotelesRemote {

	public TipoHabitacion anhadirTipoHabitacion(Hotel h, TipoHabitacion t);
	public boolean cambiarDisponibilidadHabitaciones(Hotel h, TipoHabitacion t, int reservadas);
}
