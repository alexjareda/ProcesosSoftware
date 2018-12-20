package es.unican.ps.reservas.common;

/**
 * Clase que representa un cliente que realiza una reserva en un hotel
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
public class Cliente {

	//Atributos de la clase
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private Tarjeta tarjeta;
	
	/**
	 * Constructor de la clase
	 * @param dni DNI del cliente
	 * @param nombre Nombre del cliente
	 * @param apellido1 Primer apellido del cliente
	 * @param apellido2 Segundo apellido (si tuviera) del cliente
	 * @param email Correo electronico del cliente
	 * @param tarjeta Numero de la tarjeta del cliente
	 */
	public Cliente(String dni, String nombre, String apellido1, 
			String apellido2, String email, Tarjeta tarjeta){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.tarjeta = tarjeta;
	}

	/**
	 * Metodo getter del dni de un cliente
	 * @return DNI de un cliente
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo setter del dni de un cliente
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo getter del nombre de un cliente
	 * @return Nombre de un cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo setter del nombre de un cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo getter del primer apellido de un cliente
	 * @return Primer apellido de un cliente
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Metodo setter del primer apellido de un cliente
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Metodo getter del segundo apellido de un cliente
	 * @return Segundo apellido de un cliente
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Metodo setter del segundo apellido de un cliente
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Metodo getter del email de un cliente
	 * @return Email de un cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo Setter del email de un cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo getter de la tarjeta de un cliente
	 * @return Numero de tarjeta de un cliente
	 */
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	/**
	 * Metodo setter de la tarjeta de un cliente
	 */
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
}
