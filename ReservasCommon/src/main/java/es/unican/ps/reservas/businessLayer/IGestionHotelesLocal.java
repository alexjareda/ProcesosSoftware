package es.unican.ps.reservas.businessLayer;

import javax.ejb.Local;

import es.unican.ps.reservas.entities.Hotel;
import es.unican.ps.reservas.entities.TipoHabitacion;

@Local
public interface IGestionHotelesLocal {

	public TipoHabitacion anhadirTipoHabitacion(Hotel h, TipoHabitacion t);
	public boolean cambiarDisponibilidadHabitaciones(Hotel h, TipoHabitacion t, int reservadas);
}
