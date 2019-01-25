package es.unican.ps.reservas.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Clase que representa una reserva de un tipo de habitacion concreto
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
@SuppressWarnings("serial")
@Entity
public class ReservaTipoHabitacion implements Serializable{

	//Atributos de la clase
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="reserva_fk")
	private Reserva reserva;
	
	@OneToOne
	@JoinColumn(name="tipoHabitacion_fk")
	private TipoHabitacion tipo;
	private int habitaciones;
	
	
	
	public ReservaTipoHabitacion(){
		//Nothing
	}
	
	/**
	 * Constructor de la clase
	 * @param habs Habitaciones de la reserva
	 * @param id Numero id de la reserva
	 */
	public ReservaTipoHabitacion(int habs){
		this.habitaciones = habs;
	}

	/**
	 * Metodo getter del numero de habitaciones de la reserva
	 * @return Numero de habitaciones de una reserva
	 */
	public int getHabitaciones() {
		return habitaciones;
	}

	/**
	 * Metodo setter del numero de habitaciones de la reserva
	 */
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo getter de la reserva
	 * @return La reserva
	 */
	public Reserva getReserva() {
		return reserva;
	}

	/**
	 * Metodo setter de la reserva 
	 */
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public TipoHabitacion getTipoHabitacion(){
		return this.tipo;
	}
	
	public void setTipoHabitacion(TipoHabitacion t){
		this.tipo = t;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ReservaTipoHabitacion) {
			ReservaTipoHabitacion c = (ReservaTipoHabitacion)o;
			return c.getId().equals(id);	
		}
		return false;
	}
}
