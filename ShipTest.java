package asteroids.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void mostExtendedConstructor_LegalCase() throws Exception {
		Ship myShip = new Ship(1, 2, 3, 4, 15, Math.PI / 2);
		assertEquals(myShip.getPosition().getxCoordinate(), 1);
		assertEquals(myShip.getPosition().getyCoordinate(), 2);
		assertEquals(myShip.getVelocity().getxComponent(), 3);
		assertEquals(myShip.getVelocity().getyComponent(), 4);
		assertEquals(myShip.getPosition().getxCoordinate(), 1);
	}

	@Test
	public void testShipDoubleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidOrientation() {
		fail("Not yet implemented");
	}

	@Test
	public void testTurn() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidMinimalRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMinimalRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanHaveAsVelocity() {
		fail("Not yet implemented");
	}

	@Test
	public void testThrust() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidSpeedLimit() {
		fail("Not yet implemented");
	}

}
