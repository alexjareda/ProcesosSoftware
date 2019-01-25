package testDAO;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.reservas.daoLayer.*;
import es.unican.ps.reservas.entities.*;

@SuppressWarnings("unused")
public class testReservas {

	private static EJBContainer ec;
	private static IReservasDAORemote res;
	private static Reserva reserva;
	private static Reserva nuevaReserva;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@BeforeClass
	public static void initContainer() throws Exception {
		Map properties = new HashMap();
		properties.put(EJBContainer.MODULES, new File[]{new File("classes")});
		properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "C:/glassfish4/glassfish");
		
		//Creacion del EJBContainer
		ec = EJBContainer.createEJBContainer(properties);
		res = (IReservasDAORemote) ec.getContext().lookup("java:global/ReservasDao-0.0.1-SNAPSHOT/ReservasDAO!es.unican.ps.daoLayer.implementacion.IReservasDAORemote");
		
		//Partimos con una reserva dentro de la bbdd
		res.addReserva(reserva);
	}
	
	@AfterClass
	public static void closeContainer() throws Exception {
		if (ec != null)
			ec.close();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAddReserva(){
		Date ent = new Date("01/12/2019");
		Date sal = new Date("10/12/2019");
		Cliente c = new Cliente();
		//Long id = (long) 1;
		nuevaReserva = new Reserva(ent, sal, c);
		Long idres = res.addReserva(nuevaReserva).getId();
		assertTrue(res.getReserva(idres).equals(nuevaReserva));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetReserva(){
		Date ent = new Date("01/12/2019");
		Date sal = new Date("10/12/2019");
		Cliente c = new Cliente();
		//Long id = (long) 1;
		nuevaReserva = new Reserva(ent, sal, c);
		Long idRes = res.addReserva(nuevaReserva).getId();
		assertTrue(res.getReserva(idRes).equals(nuevaReserva));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateReserva(){
		Date ent = new Date("01/12/2019");
		Date sal = new Date("10/12/2019");
		Cliente c = new Cliente();
		Long id1 = (long) 1;
		nuevaReserva = new Reserva(ent, sal, c);
		Date sal2 = new Date("10/12/2019");
		nuevaReserva.setFechaSalida(sal2);
		
		res.updateReserva(nuevaReserva);
		
		assertTrue(res.getReserva(nuevaReserva.getId()).getFechaSalida().equals(sal2));
	}
	
	@Test
	public void testRemoveReserva(){
		res.removeReserva(reserva);
		
		assertTrue(res.listReservas() == null);
	}
	
	@Test
	public void testListReservas(){
		List<Reserva> lista = new ArrayList<Reserva>();
		lista.add(reserva);
		
		assertTrue(res.listReservas().equals(lista));
	}
}
