package asteroids.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipTest {
	
	private Ship myShip;
	private static Velocity velocity_Legal, velocity_TooLarge;
	private static Ship ship_MinimalRadius, ship_Orientation45deg;
	private static Ship ship_Collision1, ship_Collision2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		velocity_Legal = new Velocity(10,20);
		velocity_TooLarge = new Velocity(300000,100);
		ship_Collision1 = new Ship(0,0,10);
		ship_Collision2 = new Ship(30,40,10);
	}

	@Before
	public void setUp() throws Exception {
		myShip = new Ship(0, 0, 10, 10, 10, 0);
		ship_MinimalRadius = new Ship(0,0,Ship.getMinimalRadius());
		ship_Orientation45deg = new Ship(0,0,0,0,Ship.getMinimalRadius(),Math.PI/4);
	}

	@Test
	public void mostExtendedConstructor_LegalCase() throws Exception {
		myShip = new Ship(1, 2, 3, 4, 15, Math.PI / 2);
		assertEquals(myShip.getPosition().getxCoordinate(), 1, 0.01);
		assertEquals(myShip.getPosition().getyCoordinate(), 2, 0.01);
		assertEquals(myShip.getVelocity().getxComponent(), 3, 0.01);
		assertEquals(myShip.getVelocity().getyComponent(), 4, 0.01);
		assertEquals(myShip.getRadius(), 15, 0.01);
		assertEquals(myShip.getOrientation(), Math.PI / 2, 0.01);
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
		assertEquals(myShip.getPosition().getxCoordinate(), 1, 0.01);
		assertEquals(myShip.getPosition().getyCoordinate(), 2, 0.01);
		assertEquals(myShip.getVelocity().getxComponent(), 0, 0.01);
		assertEquals(myShip.getVelocity().getyComponent(), 0, 0.01);
		assertEquals(myShip.getRadius(), 15, 0.01);
		assertEquals(myShip.getOrientation(), 0, 0.01);
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
		assertEquals(myShip.getPosition().getxCoordinate(), 0 + 1 * 10, 0.01);
		assertEquals(myShip.getPosition().getyCoordinate(), 0 + 1 * 10, 0.01);
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
		assertEquals(myShip.getOrientation(), 0 + 4, 0.01);
	}
	
	@Test
	public void testIsValidRadius_ValidCase() {
		assertTrue(Ship.isValidRadius(Ship.getMinimalRadius()));
	}
	
	@Test
	public void testIsValidRadius_InvalidCase() {
		assertFalse(Ship.isValidRadius(Ship.getMinimalRadius()-1));
	}
	
	@Test
	public void testIsValidMinimalRadius_ValidCase() {
		assertTrue(Ship.isValidMinimalRadius(1));
	}
	
	@Test
	public void testIsValidMinimalRadius_InvalidCase() {
		assertFalse(Ship.isValidMinimalRadius(0));
	}
	
	@Test
	public void testSetMinimalRadius_LegalRadius() {
		Ship.setMinimalRadius(5);
		assertEquals(Ship.getMinimalRadius(), 5, 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMinimalRadius_IllegalRadius() {
		Ship.setMinimalRadius(-5);
	}
	
	@Test
	public void testCanHaveAsVelocity_LegalVelocity() {
		assertTrue(ship_MinimalRadius.canHaveAsVelocity(velocity_Legal));
	}
	
	@Test
	public void testCanHaveAsVelocity_NonEffectiveVelocity() {
		assertFalse(ship_MinimalRadius.canHaveAsVelocity(null));
	}
	
	@Test
	public void testCanHaveAsVelocity_TooLargeVelocity() {
		assertFalse(ship_MinimalRadius.canHaveAsVelocity(velocity_TooLarge));
	}
	
	@Test
	public void testThrust_LegalCase() {
		ship_Orientation45deg.thrust(ship_Orientation45deg.getSpeedLimit()/2);
		assertEquals(ship_Orientation45deg.getVelocity().getxComponent(), ship_Orientation45deg.getSpeedLimit()*Math.sqrt(2)/4,0.1);
		assertEquals(ship_Orientation45deg.getVelocity().getyComponent(), ship_Orientation45deg.getSpeedLimit()*Math.sqrt(2)/4,0.1);
	}
	
	@Test
	public void testThrust_NegativeAmount() {
		ship_Orientation45deg.thrust(-5);
		assertEquals(ship_Orientation45deg.getVelocity().getxComponent(), 0, 0.01);
		assertEquals(ship_Orientation45deg.getVelocity().getyComponent(), 0, 0.01);
	}
	
	@Test
	public void testThrust_TooLargeAmount() {
		ship_Orientation45deg.thrust(ship_Orientation45deg.getSpeedLimit() * 2);
		assertEquals(ship_Orientation45deg.getVelocity().getxComponent(), ship_Orientation45deg.getSpeedLimit()*Math.sqrt(2)/2,0.1);
		assertEquals(ship_Orientation45deg.getVelocity().getyComponent(), ship_Orientation45deg.getSpeedLimit()*Math.sqrt(2)/2,0.1);
	}
	
	@Test
	public void testIsValidSpeedLimit_ValidCase() {
		assertTrue(Ship.isValidSpeedLimit(10));
	}
	
	@Test
	public void testIsValidSpeedLimit_NegativeCase() {
		assertFalse(Ship.isValidSpeedLimit(-10));
	}
	
	@Test
	public void testIsValidSpeedLimit_TooLargeCase() {
		assertFalse(Ship.isValidSpeedLimit(Ship.SPEED_OF_LIGHT+1));
	}
	
	@Test
	public void getDistanceBetween_NonIdenticalCase() {
		assertEquals(Ship.getDistanceBetween(ship_Collision1, ship_Collision2), 30, 0.01);
	}
	
	@Test
	public void getDistanceBetween_IdenticalCase() {
		assertEquals(Ship.getDistanceBetween(ship_Collision1, ship_Collision1), 0, 0.01);
	}
	
	@Test(expected=NullPointerException.class)
	public void getDistanceBetween_NonEffectiveCase() {
		Ship.getDistanceBetween(ship_Collision1, null);
	}
}