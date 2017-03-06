package asteroids.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class representing a circular space ship dealing with
 * position, velocity, orientation and radius.
 * 
 * @invar  The position of each ship must be a valid position for any ship.
 *       | isValidPosition(getPosition())
 * @invar  The orientation of each ship must be a valid orientation for any ship.
 *       | isValidOrientation(getOrientation())
 * @invar  Each ship can have its radius as radius.
 *       | canHaveAsRadius(this.getRadius())
 * @invar  The minimal radius of each ship must be a valid minimal radius for any ship.
 *       | isValidMinimalRadius(getMinimalRadius())
 * @invar  The velocity of each ship must be a valid velocity for any
 *         ship.
 *       | isValidVelocity(getVelocity())
 * @invar  Each ship can have its speed limit as speed limit .
 *       | canHaveAsSpeedLimit(this.getSpeedLimit())
 * 
 * @author Joris & Pieter
 * @version 1.0
 *
 */


public class Ship {
	/**
	 * Initialize this new ship with given xCoordinate, yCoordinate, velocity with xComponent and yComponent, radius and orientation
	 * @param xCoordinate
	 * 			xCoordinate of this new ship
	 * @param yCoordinate
	 * 			yCoordinate of this new ship
	 * @param xComponent
	 * 			xComponent of the velocity of this new ship
	 * @param yComponent
	 * 			yComponent of the velocity of this new ship
	 * @param radius
	 * 			radius of this new ship
	 * @param orientation
	 * 			orientation of this new ship
	 * @effect The position of this new ship is set to a new position with given xCoordinate and yCoordinate
	 * 			| setPosition(xCoordinate, yCoordinate)
	 * @effect The velocity of this new ship is set to a new velocity with given xComponent and yComponent
	 * 			| setVelocity(xComponent, yComponent)
	 * @effect The orientation of this new ship is set to the given orientation
	 * 			| setOrientation(orientation)
	 * @post   If the given radius is valid, the radius of this new ship is set to the given radius
	 * 			| if (isValidRadius(radius))
	 * 			|	then new.getRadius() == radius
	 * @throws	IllegalRadiusException
	 * 			The given radius is not valid
	 * 			| ! isValidRadius(radius)
	 */
	@Raw
	public Ship(double xCoordinate, double yCoordinate, double xComponent, double yComponent, 
								double radius, double orientation) throws IllegalCoordinateException, IllegalRadiusException {
		if (! isValidRadius(radius))
			throw new IllegalRadiusException();
		this.radius = radius;
		setPosition(xCoordinate, yCoordinate);
		setVelocity(xComponent, yComponent);
		setOrientation(orientation);
	}
	
	/**
	 * Initialize a new ship with given xCoordinate, yCoordinate and radius.
	 * @param xCoordinate
	 * 			xCoordinate of this new ship
	 * @param yCoordinate
	 * 			yCoordinate of this new ship
	 * @param radius
	 * 			radius of this new ship
	 * @effect This new ship is initialized with the given xCoordinate and yCoordinate as its position, the given radius as its radius,
	 * 			zero velocity and right-pointing orientation.
	 * 			| this(xCoordinate, yCoordinate, 0, 0, radius, 0)
	 */
	@Raw
	public Ship(double xCoordinate, double yCoordinate, double radius) throws IllegalCoordinateException, IllegalRadiusException {
		this(xCoordinate, yCoordinate, 0, 0, radius, 0);
	}
	
	/**
	 * Return the position of this ship.
	 */
	@Basic @Raw
	public Position getPosition() {
		return this.position.clone();
	}
	
	/**
	 * Check whether the given position is a valid position for any ship.
	 *  
	 * @param  position
	 *         The position to check.
	 * @return true iff the given position is effective.
	 *       | result == position != null
	 */
	
	public static boolean isValidPosition(Position position) {
		return position != null;
	}
	
	/**
	 * Move this ship during a given time duration.
	 * 
	 * @param duration
	 * 			The length of the time interval during which the ship is moved.
	 * @effect Each new coordinate of the position of this ship is set to the sum of the old coordinate
	 * 			and the given duration times the corresponding component of the velocity of this ship.
	 * 			| setPosition(getPosition().getxCoordinate() + duration * getVelocity().getxComponent(),
	 * 			|				getPosition().getyCoordinate() + duration * getVelocity().getyComponent())
	 * @throws IllegalArgumentException
	 * 			The given duration is strictly less than 0.
	 * 			| duration < 0
	 */
	public void move(double duration) throws IllegalArgumentException, IllegalCoordinateException {
		if (duration < 0)
			throw new IllegalArgumentException();
		setPosition(getPosition().getxCoordinate() + duration * getVelocity().getxComponent(),
				getPosition().getyCoordinate() + duration * getVelocity().getyComponent());
	}
	
	/**
	 * Set the position of this ship to the given position.
	 * 
	 * @param  xCoordinate
	 *         The new xCoordinate for the position for this ship.
	 * @param  YCoordinate
	 *         The new yCoordinate for the position for this ship.
	 * @post   The xCoordinate of the position of this new ship is equal to the given position.
	 *       | new.getPosition().getxCoordinate() == xCoordinate
	 * @post   The yCoordinate of the position of this new ship is equal to the given position.
	 *       | new.getPosition().getyCoordinate() == yCoordinate
	 * @throws IllegalCoordinateException
	 * 		   One of the given coordinates is not valid
	 * 		 | ! Position.isValidCoordinate(xCoordinate) || ! Position.isValidCoordinate(yCoordinate)
	 */
	@Raw @Model
	private void setPosition(double xCoordinate, double yCoordinate) throws IllegalCoordinateException {
		try {
			this.position.setPosition(xCoordinate, yCoordinate);
		}
		catch(NullPointerException exc) {
			// For the moment, a NullPointerException will only be thrown if this 
			//  method is used within a constructor of the Ship class.
			this.position = new Position(xCoordinate, yCoordinate);
		}
	}
	
	/**
	 * Variable registering the position of this ship.
	 */
	private Position position;
	
	
	/**
	 * Return the orientation of this ship in radians.
	 */
	@Basic @Raw
	public double getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Check whether the given orientation is a valid orientation for any ship.
	 * @param  orientation
	 *         The orientation to check.
	 * @return true iff the value of orientation is contained in the interval [0, 2*Pi]
	 *       | result == (0 <= orientation) && (orientation <= 2*Math.PI)
	*/
	public static boolean isValidOrientation(double orientation) {
		return (0 <= orientation) && (orientation <= 2*Math.PI);
	}
	
	/**
	 * Turn this ship over a given angle.
	 * 
	 * @param angle
	 * 			The angle over which this ship must be turned.
	 * @effect The new orientation of this ship is set to the current orientation plus the given angle.
	 * 			| setOrientation(getOrientation() + angle)
	 */
	public void turn(double angle) {
		setOrientation(getOrientation() + angle);
	}
	
	/**
	 * Set the orientation of this ship to the given orientation.
	 * 
	 * @param  orientation
	 *         The new orientation for this ship.
	 * @pre    The given orientation must be a valid orientation for any ship.
	 *       | isValidOrientation(orientation)
	 * @post   The orientation of this ship is equal to the given orientation.
	 *       | new.getOrientation() == orientation
	 */	
	@Raw @Model
	private void setOrientation(double orientation) {
		assert isValidOrientation(orientation);
		this.orientation = orientation;
	}
	
	/**
	 * Variable registering the orientation of this ship in radians.
	 */
	private double orientation;
	
	
	/**
	 * Return the radius of this ship.
	 */
	@Basic @Raw @Immutable
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Check whether this ship can have the given radius as its radius.
	 *  
	 * @param  radius
	 *         The radius to check.
	 * @return true iff the given radius is larger than the minimal radius for any ship.
	 *       | result == (radius >= getMinimalRadius())
	*/
	@Raw
	public static boolean isValidRadius(double radius) {
		return radius >= getMinimalRadius();
	}
	
	/**
	 * Variable registering the radius of this ship.
	 */
	private final double radius;
	
	
	/**
	 * Return the minimal radius of any ship.
	 */
	@Basic @Raw
	public static double getMinimalRadius() {
		return minimalRadius;
	}
	
	/**
	 * Check whether the given minimal radius is a valid minimal radius for any ship.
	 *  
	 * @param  minimal radius
	 *         The minimal radius to check.
	 * @return true iff the given minimalRadius is positive
	 *       | result == minimalRadius > 0
	*/
	public static boolean isValidMinimalRadius(double minimalRadius) {
		return minimalRadius > 0;
	}
	
	/**
	 * Set the minimal radius of any ship to the given minimal radius.
	 * 
	 * @param  minimalRadius
	 *         The new minimal radius for a ship.
	 * @post   The minimal radius of any ship is equal to the given minimal radius.
	 *       | Ship.getMinimalRadius() == minimalRadius
	 * @throws IllegalArgumentException
	 *         The given minimal radius is not a valid minimal radius for any ship.
	 *       | ! isValidMinimalRadius(getMinimalRadius())
	 */
	@Raw
	public static void setMinimalRadius(double minimalRadius) throws IllegalArgumentException {
		if (! isValidMinimalRadius(minimalRadius))
			throw new IllegalArgumentException();
		Ship.minimalRadius = minimalRadius;
	}
	
	/**
	 * Variable registering the minimal radius of this ship.
	 */
	private static double minimalRadius = 10;
	
	
	
	/**
	 * Return the velocity of this ship.
	 */
	@Basic @Raw
	public Velocity getVelocity() {
		if (this.velocity == null)
			return null;
		return this.velocity.clone();
	}
	
	/**
	 * Check whether the given velocity is a valid velocity for any ship.
	 *  
	 * @param  velocity
	 *         The velocity to check.
	 * @return true iff the given velocity is effective.
	 *       | result == velocity != null
	*/
	public boolean canHaveAsVelocity(Velocity velocity) {
		if (velocity == null)
			return false;
		if (Math.hypot(velocity.getxComponent(), velocity.getyComponent()) > getSpeedLimit())
			return false;
		return true;
	}
	
	/**
	 * Change the velocity of this ship with a given amount.
	 * 
	 * @param amount
	 * 		The amount to be added to the velocity.
	 * @effect If amount is non-negative , the x component (resp. y component) of the new
	 * 			velocity of this ship is set to the sum of the current component
	 * 			plus amount times the cosine (resp. sine) of the orientation of this ship.
	 * 			| if (amount >= 0)
	 * 			|	then setVelocity(getVelocity().getxComponent() + amount * Math.cos(getOrientation()),
	 * 			|						getVelocity().getyComponent() + amount * Math.sin(getOrientation()))
	 * 			
	 */
	public void thrust(double amount) {
		if (amount >= 0)
			setVelocity(getVelocity().getxComponent() + amount * Math.cos(getOrientation()),
					 	getVelocity().getyComponent() + amount * Math.sin(getOrientation()));
	}
	
	/**
	 * Set the velocity of this ship to the given velocity.
	 * 
	 * @param  xComponent
	 *         The new xComponent for the velocity for this ship.
	 * @param  YComponent
	 *         The new yComponent for the velocity for this ship.
	 * @post   If this ship can have the velocity with the given xComponent and  given yComponent as its velocity, 
	 * 			then the xComponent of the velocity of this new ship is equal to the given xComponent,
	 * 			and the yComponent of the velocity of this new ship is equal to the given yComponent.
	 *       | if (this.canHaveAsVelocity(new Velocity(xComponent,yComponent))
	 *       | 		then (new.getVelocity().getxComponent() == xComponent)
	 *       |			&& (new.getVelocity().getyComponent() == yComponent)
	 * @post   If this ship cannot have the velocity with the given xComponent and  given yComponent as its velocity,
	 * 			the new velocity of this ship is set to a velocity such that the direction corresponds with the
	 *			velocity with given xComponent and yComponent, but the speed is set to the speedLimit. More concretely,
	 *			the xComponent of the new velocity of this ship is set to (xComponent * getSpeedLimit() / speed) and the
	 *			yComponent of the new velocity of this ship is set to (yComponent * getSpeedLimit() / speed), where
	 *			speed is the speed corresponding with the velocity with given xComponent and yComponent.
	 *		 | if (! this.canHaveAsVelocity(new Velocity(xComponent, yComponent))
	 *		 | 		then (new.getVelocity().getxComponent() == xComponent * getSpeedLimit / Math.hypot(xComponent, yComponent))
	 *		 |			&& (new.getVelocity().getyComponent() == yComponent * getSpeedLimit / Math.hypot(xComponent, yComponent))
	 */
	@Raw
	private void setVelocity(double xComponent, double yComponent) {
		if (this.getVelocity() == null)
			this.velocity = new Velocity(0, 0);
		if (this.canHaveAsVelocity(new Velocity(xComponent, yComponent)))
			this.velocity.setVelocity(xComponent, yComponent);
		else {
			double speed = Math.hypot(xComponent, yComponent);
			xComponent = xComponent * getSpeedLimit() / speed;
			yComponent = yComponent * getSpeedLimit() / speed;
			setVelocity(xComponent, yComponent);
		}
	}
	
	/**
	 * Variable registering the velocity of this ship.
	 */
	private Velocity velocity;
	
	
	/**
	 * Return the speed limit of this ship.
	 */
	@Basic @Raw @Immutable
	public double getSpeedLimit() {
		return this.speedLimit;
	}
	
	/**
	 * Check whether this ship can have the given speed limit as its speed limit.
	 *  
	 * @param  speedLimit
	 *         The speed limit to check.
	 * @return True if and only if the given speed limit is strictly positive and not greater than the speed of light
	 *       | result == (0 < speedLimit) && (speedLimit <= SPEED_OF_LIGHT)
	*/
	@Raw
	public static boolean isValidSpeedLimit(double speedLimit) {
		return (0 < speedLimit) && (speedLimit <= SPEED_OF_LIGHT);
	}
	
	
	/**
	 * Variable registering the speed limit of this ship.
	 */
	private final double speedLimit = SPEED_OF_LIGHT;
	
	/**
	 * Constant representing the speed of light (i.e. 300000 km/s)
	 */
	
	public static final double SPEED_OF_LIGHT = 300000;
	
	
	/**
	 * Calculates the distance between two ships
	 * @param ship1
	 * 			The first ship
	 * @param ship2
	 * 			The second ship
	 * @return If the two ships are effective and different, the distance between the two ships.
	 * 			| 
	 * 			| 
	 * @return If the two ships are effective and identical, zero.
	 * 			| result == 0
	 * @throws NullPointerException
	 * 			One of the ships is not effective
	 * 			| (ship1 == null) || (ship2 == null)
	 */
	public static double getDistanceBetween(Ship ship1, Ship ship2) throws NullPointerException{
		if ((ship1 != null) && (ship1 == ship2))
			return 0;
		double result = Math.hypot(ship1.getPosition().getxCoordinate() - ship2.getPosition().getxCoordinate(),
				ship1.getPosition().getyCoordinate() - ship2.getPosition().getyCoordinate());
		result = result - ship1.getRadius() - ship2.getRadius();
		return result;
	}
}
