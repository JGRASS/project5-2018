package domenske_klase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimTest {
	
	private Tim t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Tim();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetNazivTima() {
		t.setNazivTima("Ferrari");
		assertEquals("Ferrari", t.getNazivTima());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivTimaNull() {
		t.setNazivTima(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivTimaPrazanString() {
		t.setNazivTima("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVozaciNull() {
		t.setVozaci(null);
	}

	@Test
	public void testSetPoeni() {
		t.setPoeni(10);
		assertEquals(10,t.getPoeni());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPoeniLose() {
		t.setPoeni(-1);
	}

	@Test
	public void testSetPobede() {
		t.setPobede(2);
		assertEquals(2, t.getPobede());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPobedeLose() {
		t.setPobede(-2);
	}
	

}
