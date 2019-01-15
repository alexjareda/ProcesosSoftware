package es.unican.ps.reservas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Clase que representa una reserva de habitaciones a un hotel
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */

@SuppressWarnings({ "serial", "unused" })
@Entity
public class Reserva implements Serializable{

	//Atributos de la clase
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date fechaEntrada;
	private Date fechaSalida;
	private double importe;
	private Cliente c;
	private Tarjeta t;
	
	//@ManyToMany(mappedBy="reservaTipoHabitacion", fetch=FetchType.EAGER)
	private List<ReservaTipoHabitacion> lista;
	
	
	public Reserva(){
		
	}
	
	/**
	 * Constructor de la clase
	 * @param id Numero id de la reserva
	 * @param entrada Fecha de entrada al hotel
	 * @param salida Fecha de salida al hotel
	 */
	public Reserva(int id, Date entrada, Date salida){
		this.fechaEntrada = entrada;
		this.fechaSalida = salida;
	}
	
	/**
	 * Metodo getter del numero id de una reserva de hotel
	 * @return Numero id de una reserva
	 */
	public Long getId(){
		return this.id;
	}
	
	/**
	 * Metodo setter del numero id de una reserva de hotel
	 */
	public void setId(){
		//El id de las reservas no se modifica
	}
	
	/**
	 * Metodo getter de la fecha de entrada a un hotel
	 * @return Fecha de entrada a un hotel
	 */
	public Date getFechaEntrada(){
		return this.fechaEntrada;
	}
	
	/**
	 * Metodo setter de la fecha de entrada a un hotel
	 */
	public void setFechaEntrada(Date entrada){
		this.fechaEntrada = entrada;
	}
	
	/**
	 * Metodo getter de la fecha de salida a un hotel
	 * @return Fecha de salida a un hotel
	 */
	public Date getFechaSalida(){
		return this.fechaSalida;
	}
	
	/**
	 * Metodo setter de la fecha de salida a un hotel
	 */
	public void setFechaSalida(Date salida){
		this.fechaSalida = salida;
	}
	
	/**
	 * Metodo getter del importe de una reserva de hotel
	 * @return Importe de una reserva
	 */
	public double getImporte(){
		return this.importe;
	}
	
	/**
	 * Metodo setter del importe de una reserva
	 */
	public void setImporte(double imp){
		//El importe de las reservas se calcula con las habitaciones y su precio
	}
	
	/**
	 * Metodo getter del cliente de una reserva
	 * @return Cliente de una reserva
	 */
	public Cliente getCliente(){
		return this.c;
	}
	
	/**
	 * Metodo setter del cliente de una reserva
	 */
	public void setCliente(Cliente c){
		this.c = c;
	}
	
	/**
	 * Metodo getter de la tarjeta de credito de un cliente
	 * @return Tarjeta de credito de un cliente
	 */
	public Tarjeta getTarjeta(){
		return this.t;
	}
	
	/**
	 * Metodo setter de la tarjeta de credito de un cliente
	 */
	public void setTarjeta(Tarjeta t){
		this.t=t;
	}
	
	/**
	 * Metodo getter de la lista de habitaciones de una reserva
	 * @return Lista de habitaciones de una reserva
	 */
	public List<ReservaTipoHabitacion> getLista(){
		return this.lista;
	}
	
	/**
	 * Metodo setter de la lista de habitaciones de una reserva
	 */
	public void setLista(List<ReservaTipoHabitacion> l){
		this.lista = l;
	}
}
