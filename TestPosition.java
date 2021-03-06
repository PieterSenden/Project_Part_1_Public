package asteroids.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import asteroids.model.IllegalCoordinateException;
import asteroids.model.Position;

public class TestPosition {
	
	private static Position position_00, position_34;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		position_00 = new Position(0,0);
		position_34 = new Position(3,4);
	}
	
	@Test
	public void testConstructor_LegalCase() {
		Position myPosition = new Position(1,2);
		assertEquals(myPosition.getxCoordinate(), 1, 0.01);
		assertEquals(myPosition.getyCoordinate(), 2, 0.01);
	}
	
	@Test(expected=IllegalCoordinateException.class)
	public void testConstructor_IllegalCase() {
		new Position(Double.POSITIVE_INFINITY,2);
	}
	
	@Test
	public void testIsValidCoordinate_ValidCase() {
		assertTrue(Position.isValidCoordinate(0));
	}
	
	@Test
	public void testIsValidCoordinate_InfiniteCase() {
		assertFalse(Position.isValidCoordinate(Double.NEGATIVE_INFINITY));
	}
	
	@Test
	public void testIsValidCoordinate_NaNCase() {
		assertFalse(Position.isValidCoordinate(Double.NaN));
	}
	
	@Test
	public void testSetxCoordinate_LegalCase() {
		position_00.setxCoordinate(3);
		assertEquals(position_00.getxCoordinate(), 3, 0.01);
	}
	
	@Test(expected=IllegalCoordinateException.class)
	public void testSetxCoordinate_IllegalCase() {
		position_00.setxCoordinate(Double.POSITIVE_INFINITY);
	}
	
	@Test
	public void testSetyCoordinate_LegalCase() {
		position_00.setyCoordinate(5);
		assertEquals(position_00.getyCoordinate(), 5, 0.01);
	}
	
	@Test(expected=IllegalCoordinateException.class)
	public void testSetyCoordinate_IllegalCase() {
		position_00.setyCoordinate(Double.NEGATIVE_INFINITY);
	}
	
	@Test
	public void clone_RegularCase() {
		Position newPosition = position_00.clone();
		assertNotEquals(position_00, newPosition);
		assertEquals(position_00.getxCoordinate(), newPosition.getxCoordinate(), 0.01);
		assertEquals(position_00.getyCoordinate(), newPosition.getyCoordinate(), 0.01);
	}
	
	@Test
	public void getDistanceBetween_RegularCase() {
		assertEquals(Position.getDistanceBetween(position_00, position_34), 5, 0.01);
	}
	
	@Test(expected=NullPointerException.class)
	public void getDistanceBetween_NonEffectiveCase() {
		Position.getDistanceBetween(position_00, null);
	}
}