package domenske_klase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VozacTest {
	
	private Vozac v;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		v = new Vozac();
	}

	@After
	public void tearDown() throws Exception {
		v = null;
	}
	@Test
	public void testSetIme() {
		v.setIme("Sebastian");
		assertEquals("Sebastian",v.getIme());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		v.setIme(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImePrazanString() {
		v.setIme("");
	}
	@Test
	public void testSetPrezime() {
		v.setPrezime("Vettel");
		assertEquals("Vettel",v.getPrezime());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeNull() {
		v.setPrezime(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimePrazanString() {
		v.setPrezime("");
	}
	@Test
	public void testSetPobede() {
		v.setPobede(2);
		assertEquals(2,v.getPobede());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPobedeLose() {
		v.setPobede(-2);
	}
	@Test
	public void testSetPoeni() {
		v.setPoeni(100);
		assertEquals(100,v.getPoeni());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPoeniLose() {
		v.setPoeni(-100);
	}
	@Test
	public void testSetTim() {
		v.setTim("Ferrari");
		assertEquals("Ferrari",v.getTim());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTimNull() {
		v.setTim(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTimPrazanString() {
		v.setTim("");
	}
	
	@Test
	public void testSetDrzava() {
		v.setDrzava("German");
		assertEquals("German", v.getDrzava());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDrzavaNull() {
		v.setDrzava(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDrzavaPrazanString() {
		v.setDrzava("");
	}

	@Test
	public void testToString() {
		v.setIme("Sebastian");
		v.setPrezime("Vettel");
		v.setTim("Ferrari");
		v.setPoeni(100);
		v.setPobede(2);
		v.setDrzava("German");
		assertEquals("Vozac [ime=Sebastian, prezime=Vettel, tim=Ferrari, poeni=100, pobede=2, drzava=German" + "]", v.toString());
	}

}
