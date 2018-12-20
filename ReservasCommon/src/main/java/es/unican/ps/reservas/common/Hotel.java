package es.unican.ps.reservas.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un hotel, con un catalogo de habitaciones(disponibles o no)
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
public class Hotel {

	//Atributos de la clase
	private int id;
	private String nombre;
	private String direccion;
	private String localidad;
	private List<TipoHabitacion> habitaciones;
	private List<Reserva> reservas;
	
	/**
	 * Constructor de la clase
	 * @param nombre Nombre del hotel
	 * @param localidad Localidad donde se ubica el hotel
	 */
	public Hotel(String nombre, String localidad){
		this.nombre = nombre;
		this.localidad = localidad;
		this.habitaciones = new ArrayList<TipoHabitacion>();
	}
	
	/**
	 * Meytodo getter del id de un hotel
	 * @return Id de un hotel
	 */
	@SuppressWarnings("unused")
	private int getId(){
		return this.id;
	}
	
	/**
	 * Metodo setter del id de un hotel
	 * @param id
	 */
	public void setId(int id){
		this.id=id;
	}
	
	/**
	 * Metodo getter del nombre de un hotel
	 * @return Devuelve el nombre de un hotel
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	/**
	 * Metodo setter del nombre de un hotel
	 */
	public void setNombre(String nom){
		this.nombre = nom;
	}
	
	/**
	 * Metodo getter de la direccion de un hotel
	 * @return Devuelve la direccion de un hotel
	 */
	public String getDireccion(){
		return this.direccion;
	}
	
	/**
	 * Metodo setter de la direccion de un hotel
	 */
	public void setDireccion(String dir){
		this.direccion = dir;
	}
	
	/**
	 * Metodo getter de la localidad de un hotel
	 * @return Devuelve la localidad de un hotel
	 */
	public String getLocalidad(){
		return this.localidad;
	}
	
	/**
	 * Metodo setter de la localidad de un hotel
	 */
	public void setLocalidad(String loc){
		this.localidad = loc;
	}
	
	/**
	 * Metodo getter de las habitaciones de un hotel
	 * @return La lista de los tipos de habitaciones de un hotel
	 */
	public List<TipoHabitacion> getHabitaciones(){
		return this.habitaciones;
	}
	
	/**
	 * Metodo setter de las habitaciones de un hotel
	 */
	public void setHabitaciones(List<TipoHabitacion> habs){
		this.habitaciones = habs;
	}
	
	/**
	 * Metodo getter de las reservas del hotel
	 * @return La lista de reservas del hotel
	 */
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	/**
	 * Metodo setter de las reservas de un tipo de habitaciones
	 */
	public void setReservas(List<Reserva> reservs){
		this.reservas = reservs;
	}
}
