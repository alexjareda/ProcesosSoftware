package es.unican.ps.reservas.common;

/**
 * Clase que representa un tipo concreto de habitacion dentro del
 * catalogo de habitaciones de un hotel
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
public class TipoHabitacion {

	//Atributos de la clase
	private String descripcion;
	private double precioPorNoche;
	private int disponibles;
	
	/**
	 * Constructor de la clase
	 * @param desc Descripcion del tipo de habitacion
	 * @param precio Precio por noche en este tipo de habitacion
	 * @param num Numero disponibles de habitaciones de este tipo
	 */
	public TipoHabitacion(String desc, double precio, int num){
		this.descripcion = desc;
		this.precioPorNoche = precio;
		this.disponibles = num;
	}
	
	/**
	 * Metodo getter de la descripcion de este tipo de habitaciones
	 * @return
	 */
	public String getDescripcion(){
		return this.descripcion;
	}
	
	/**
	 * Metodo setter de la descripcion de este tipo de habitaciones
	 * @param desc
	 */
	public void setDescripcion(String desc){
		this.descripcion = desc;
	}
	
	/**
	 * Metodo getter del precio por noche en este tipo de habitaciones
	 * @return
	 */
	public double getPrecioPorNoche(){
		return this.precioPorNoche;
	}
	
	/**
	 * Metodo setter del precio por noche en este tipo de habitaciones
	 * @param p
	 */
	public void setPrecioPorNoche(double p){
		this.precioPorNoche = p;
	}
	
	/**
	 * Metodo getter de las habitaciones disponibles 
	 * @return Devuelve el numero de habitaciones disponibles de este tipo de habitaciones
	 */
	public int getDisponibles(){
		return this.disponibles;
	}
	
	/**^
	 * Metodo setter de habitaciones disponibles de este tipo de habitaciones
	 * @param d Numero de habitaciones disponibles
	 */
	public void setDisponibles(int d){
		this.disponibles = d;
	}
}
