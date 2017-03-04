package asteroids.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipTest {

	private Ship myShip;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		myShip = new Ship(0, 0, 10, 10, 10, 0);
	}

	@Test
	public void mostExtendedConstructor_LegalCase() throws Exception {
		myShip = new Ship(1, 2, 3, 4, 15, Math.PI / 2);
		assertEquals(myShip.getPosition().getxCoordinate(), 1);
		assertEquals(myShip.getPosition().getyCoordinate(), 2);
		assertEquals(myShip.getVelocity().getxComponent(), 3);
		assertEquals(myShip.getVelocity().getyComponent(), 4);
		assertEquals(myShip.getRadius(), 15);
		assertEquals(myShip.getOrientation(), Math.PI / 2);
	}
	
	@Test(expected = IllegalCoordinateException.class)
	public void mostExtendedConstructor_IllegalCoordinate() throws Exception {
		myShip = new Ship(Double.NaN, 2, 3, 4, 15, Math.PI / 2);
	}
	
	@Test(expected = IllegalRadiusException.class)
	public void mostExtendedConstructor_IllegalRadius() throws Exception {
		myShip = new Ship(1, 2, 3, 4, 3, Math.PI / 2);
	}
	
	@Test
	public void leastExtendedConstructor_LegalCase() throws Exception {
		myShip = new Ship(1, 2, 15);
		assertEquals(myShip.getPosition().getxCoordinate(), 1);
		assertEquals(myShip.getPosition().getyCoordinate(), 2);
		assertEquals(myShip.getVelocity().getxComponent(), 0);
		assertEquals(myShip.getVelocity().getyComponent(), 0);
		assertEquals(myShip.getRadius(), 15);
		assertEquals(myShip.getOrientation(), 0);
	}
	
	@Test(expected = IllegalCoordinateException.class)
	public void leastExtendedConstructor_IllegalCoordinate() throws Exception {
		myShip = new Ship(Double.NaN, 2, 15);
	}
	
	@Test(expected = IllegalRadiusException.class)
	public void leastExtendedConstructor_IllegalRadius() throws Exception {
		myShip = new Ship(1, 2, 3);
	}

	@Test
	public void isValidPosition_TrueCase() {
		assertTrue(Ship.isValidPosition(new Position(1, 1)));
	}

	@Test
	public void isValidPosition_FalseCase() {
		assertFalse(Ship.isValidPosition(null));
	}
	
	@Test
	public void move_LegalCase() {
		myShip.move(1);
		assertEquals(myShip.getPosition().getxCoordinate(), 0 + 1 * 10);
		assertEquals(myShip.getPosition().getyCoordinate(), 0 + 1 * 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void move_InvalidDuration() {
		myShip.move(-2);
	}

	@Test
	public void isValidOrientation_TrueCase() {
		assertTrue(Ship.isValidOrientation(Math.PI / 2));
	}
	
	@Test
	public void isValidOrientation_FalseCase() {
		assertFalse(Ship.isValidOrientation(-10));
	}

	@Test
	public void turn_LegalCase() {
		myShip.turn(4);
		assertEquals(myShip.getOrientation(), 0 + 4);
	}
	
	// Vanaf hier doet Joris
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
