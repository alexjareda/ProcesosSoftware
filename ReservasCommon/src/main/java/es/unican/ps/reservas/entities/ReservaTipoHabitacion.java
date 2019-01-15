package es.unican.ps.reservas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	private int habitaciones;
	private int numReserva;
	
	
	
	public ReservaTipoHabitacion(){
		
	}
	
	/**
	 * Constructor de la clase
	 * @param habs Habitaciones de la reserva
	 * @param id Numero id de la reserva
	 */
	public ReservaTipoHabitacion(int habs, int id){
		this.habitaciones = habs;
		this.numReserva = id;
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
	 * Metodo getter del numero id de la reserva
	 * @return Numero id de la reserva
	 */
	public int getNumReserva() {
		return numReserva;
	}

	/**
	 * Metodo setter del numero de la reserva 
	 */
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	
	public Long getId(){
		return this.id;
	}
	
}
