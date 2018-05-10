package domenske_klase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RezultatTest {

	private Rezultat r;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r = new Rezultat();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testSetVozacIme() {
		Vozac v = new Vozac();
		v.setIme("Sebastian");
		r.setVozac(v);
		assertEquals("Sebastian",v.getIme());
	}
	@Test
	public void testSetVozacPrezime() {
		Vozac v = new Vozac();
		v.setPrezime("Vettel");
		r.setVozac(v);
		assertEquals("Vettel",v.getPrezime());
	}
	@Test
	public void testSetVozacPobede() {
		Vozac v = new Vozac();
		v.setPobede(2);
		r.setVozac(v);
		assertEquals(2,v.getPobede());
	}
	@Test
	public void testSetVozacPoeni() {
		Vozac v = new Vozac();
		v.setPoeni(100);
		r.setVozac(v);
		assertEquals(100,v.getPoeni());
	}
	@Test
	public void testSetVozacTim() {
		Vozac v = new Vozac();
		v.setTim("Ferrari");
		r.setVozac(v);
		assertEquals("Ferrari",v.getTim());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVozacNull() {
		r.setVozac(null);
	}
	
	@Test
	public void testSetVreme() {
		r.setVreme("08-05-2018 16-31-59");
		assertEquals("08-05-2018 16-31-59", r.getVreme());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVremeNull() {
		r.setVreme(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVremePrazanString() {
		r.setVreme("");
	}


	@Test
	public void testSetMesto() {
		r.setMesto(1);
		assertEquals(1, r.getMesto());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetMestoLose() {
		r.setMesto(0);
	}
	

}
