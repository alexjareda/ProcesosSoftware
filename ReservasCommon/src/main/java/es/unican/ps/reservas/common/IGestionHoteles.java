package es.unican.ps.reservas.common;

public interface IGestionHoteles {

	public TipoHabitacion anhadirTipoHabitacion(Hotel h, TipoHabitacion t);
	public boolean cambiarDisponibilidadHabitaciones(Hotel h, TipoHabitacion t, int reservadas);
}
