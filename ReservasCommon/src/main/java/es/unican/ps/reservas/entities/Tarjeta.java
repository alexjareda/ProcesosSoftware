package es.unican.ps.reservas.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Clase que representa una tarjeta de pago
 * 
 * @author Alejandro Jareda & Guillermo Argumosa
 *
 */
@SuppressWarnings("serial")
@Entity
public class Tarjeta implements Serializable{

	//Atributos de la clase
	@OneToOne
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;
	
	@Id
	private int numero;
	
	private int cvc;
	private int mesCaducidad;
	private int anioCaducidad;
	private TipoTarjeta tipo; //VISA, MASTERCARD o AMERICAN_EXPRESS
	
	
	public Tarjeta(){
		//Nothing
	}
	
	/**
	 * Constructor de la clase
	 * @param c Cliente al que se le asigna la tarjeta
	 * @param num Numero de la tarjeta 
	 * @param cvc Codigo de seguridad de la tarjeta
	 * @param mes Mes de caducidad de la tarjeta
	 * @param anio Anio de caducidad de la tarjeta
	 * @param tipo Tipo de tarjeta 
	 */
	public Tarjeta(Cliente c, int num, int cvc, int mes, int anio, TipoTarjeta tipo){
		this.cliente = c;
		this.numero = num;
		this.cvc = cvc;
		this.mesCaducidad = mes;
		this.anioCaducidad = anio;
		this.tipo = tipo;
	}

	/**
	 * Metodo getter del cliente de la tarjeta
	 * @return Cliente de la tarjeta
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo setter del cliente de la tarjeta
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo getter del numero de la tarjeta
	 * @return Numero de la tarjeta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo setter del numero de la tarjeta
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Metodo getter del codigo de seguridad de la tarjeta
	 * @return Codigo de seguridad de la tarjeta
	 */
	public int getCvc() {
		return cvc;
	}

	/**
	 * Metodo setter del codigo de seguridad de la tarjeta
	 */
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	/**
	 * Metodo getter del mes de caducidad de la tarjeta
	 * @return Mes de caducidad de la tarjeta
	 */
	public int getMesCaducidad() {
		return mesCaducidad;
	}

	/**
	 * Metodo setter del mes de caducidad de la tarjeta
	 */
	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	/**
	 * Metodo getter del anio de caducidad de la tarjeta
	 * @return Anio de caducidad de la tarjeta
	 */
	public int getAnioCaducidad() {
		return anioCaducidad;
	}

	/**
	 * Metodo setter del anio de caducidad de la tarjeta
	 * @param anioCaducidad
	 */
	public void setAnioCaducidad(int anioCaducidad) {
		this.anioCaducidad = anioCaducidad;
	}
	
	/**
	 * Metodo getter del tipo de tarjeta 
	 * @return Tipo de tarjeta
	 */
	public TipoTarjeta getTipo(){
		return this.tipo;
	}
	
	/**
	 * Metodo setter del tipo de tarjeta
	 */
	public void setTipo(TipoTarjeta t){
		this.tipo = t;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Tarjeta) {
			Tarjeta c = (Tarjeta)o;
			return c.getNumero() == numero;	
		}
		return false;
	}
}
