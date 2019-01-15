package es.unican.ps.reservas.businessLayer;

import es.unican.ps.reservas.entities.Hotel;
import es.unican.ps.reservas.entities.TipoHabitacion;

public interface IGestionHoteles {

	public TipoHabitacion anhadirTipoHabitacion(Hotel h, TipoHabitacion t);
	public boolean cambiarDisponibilidadHabitaciones(Hotel h, TipoHabitacion t, int reservadas);
}
