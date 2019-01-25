package es.unican.ps.reservas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Clase que representa un hotel, con un catalogo de habitaciones(disponibles o no)
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
@SuppressWarnings({ "serial"})
@Entity
public class Hotel implements Serializable{

	//Atributos de la clase
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String direccion;
	private String localidad;
	
	@OneToMany
	@JoinColumn(name="Hotel_fk")
	private List<TipoHabitacion> habitaciones;
	
	@OneToMany(mappedBy="hotel")
	@JoinColumn(name="Hotel_fk")
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy="hotel")
	@JoinColumn(name="hotel_fk")
	private List<Cliente> clientes;
	
	public Hotel() {
		//Nothing
	}
	
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
	private Long getId(){
		return this.id;
	}
	
	/**
	 * Metodo setter del id de un hotel
	 * @param id
	 */
	public void setId(Long id){
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
	 * Metodo getter de los tipos de habitaciones de un hotel
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
	
	public List<Cliente> getClientes(){
		return this.clientes;
	}
	
	public void setClientes(List<Cliente> lista2){
		this.clientes = lista2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Hotel) {
			Hotel c = (Hotel)o;
			return c.getId().equals(id) && c.getNombre().equals(nombre);	
		}
		return false;
	}
}