package domenske_klase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrkaTest {
	
	private Trka t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Trka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetNazivTrke() {
		t.setNazivTrke("Monaco Grand Prix");
		assertEquals("Monaco Grand Prix", t.getNazivTrke());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivTrkeNull() {
		t.setNazivTrke(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivTrkePrazanString() {
		t.setNazivTrke("");
	}

	@Test
	public void testSetDrzava() {
		t.setDrzava("Monaco");
		assertEquals("Monaco", t.getDrzava());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDrzavaNull() {
		t.setDrzava(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDrzavaPrazanString() {
		t.setDrzava("");
	}

	@Test
	public void testSetDatum() {
		t.setDatum("2018-05-27");
		assertEquals("2018-05-27", t.getDatum());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumNull() {
		t.setDatum(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumPrazanString() {
		t.setDatum("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetRezultat() {
		t.setRezultat(null);
	}

	@Test
	public void testSetRunda() {
		t.setRunda(6);
		assertEquals(6, t.getRunda());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetRundaLose() {
		t.setRunda(-6);
	}

}
