package asteroids.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class representing the position of a ship.
 * 
 * @author Joris & Pieter
 * @version 1.0
 * 
 * @invar  The xCoordinate of each position must be a valid xCoordinate for any position.
 *       | isValidxCoordinate(getxCoordinate())
 * @invar  The yCoordinate of each position must be a valid yCoordinate for any position.
 *       | isValidyCoordinate(getyCoordinate())
 */
public class Position {
	
	/**
	 * Initialize this new position with given xCoordinate and yCoordinate.
	 *
	 * @param  xCoordinate
	 *         The xCoordinate for this new position.
	 * @param  yCoordinate
	 *         The yCoordinate for this new position.
	 * @effect The xCoordinate of this new position is set to the given xCoordinate.
	 *       | this.setxCoordinate(xCoordinate)
	 * @effect The yCoordinate of this new position is set to the given yCoordinate.
	 *       | this.setyCoordinate(yCoordinate)
	 * @throws IllegalCoordinateException
	 * 		   One of the given coordinates is not valid.
	 * 		 | ! isValidCoordinate(xCoordinate) || ! isValidCoordinate(yCoordinate)
	 */
	public Position(double xCoordinate, double yCoordinate) throws IllegalCoordinateException {
		this.setxCoordinate(xCoordinate);
		this.setyCoordinate(yCoordinate);
	}
	
	
	/**
	 * Return the xCoordinate of this position.
	 */
	@Basic @Raw
	public double getxCoordinate() {
		return this.xCoordinate;
	}
	
	/**
	 * Check whether the given Coordinate is a valid Coordinate for any position.
	 *  
	 * @param  Coordinate
	 *         The Coordinate to check.
	 * @return true iff the given Coordinate is a finite number.
	 *       | result == Double.isFinite(Coordinate)
	*/
	public static boolean isValidCoordinate(double Coordinate) {
		return Double.isFinite(Coordinate);
	}
	
	/**
	 * Set the xCoordinate of this position to the given xCoordinate.
	 * 
	 * @param  xCoordinate
	 *         The new xCoordinate for this position.
	 * @post   The xCoordinate of this new position is equal to the given xCoordinate.
	 *       | new.getxCoordinate() == xCoordinate
	 * @throws IllegalCoordinateException
	 *         The given xCoordinate is not a valid xCoordinate for any position.
	 *       | ! isValidxCoordinate(getxCoordinate())
	 */
	@Raw
	public void setxCoordinate(double xCoordinate) throws IllegalCoordinateException {
		if (! isValidCoordinate(xCoordinate))
			throw new IllegalCoordinateException();
		this.xCoordinate = xCoordinate;
	}
	
	/**
	 * Variable registering the xCoordinate of this position.
	 */
	private double xCoordinate;
	
	
	/**
	 * Return the yCoordinate of this position.
	 */
	@Basic @Raw
	public double getyCoordinate() {
		return this.yCoordinate;
	}
	
	/**
	 * Set the yCoordinate of this position to the given yCoordinate.
	 * 
	 * @param  yCoordinate
	 *         The new yCoordinate for this position.
	 * @post   The yCoordinate of this new position is equal to the given yCoordinate.
	 *       | new.getyCoordinate() == yCoordinate
	 * @throws IllegalCoordinateException
	 *         The given yCoordinate is not a valid yCoordinate for any position.
	 *       | ! isValidyCoordinate(getyCoordinate())
	 */
	@Raw
	public void setyCoordinate(double yCoordinate) throws IllegalCoordinateException {
		if (! isValidCoordinate(yCoordinate))
			throw new IllegalCoordinateException();
		this.yCoordinate = yCoordinate;
	}
	
	/**
	 * Variable registering the yCoordinate of this position.
	 */
	private double yCoordinate;
	
	
	/**
	 * Set the xCoordinate and yCoordinate of this position to the given xCoordinate and yCoordinate
	 * @param xCoordinate
	 * 			The new xCoordinate for this position.
	 * @param yCoordinate
	 * 			The new yCoordinate for this position.
	 * @effect The new xCoordinate of this position is set to the given xCoordinate.
	 * 			| setxCoordinate(xCoordinate)
	 * @effect The new yCoordinate of this position is set to the given yCoordinate.
	 * 			| setyCoordinate(yCoordinate)
	 */
	public void setPosition(double xCoordinate, double yCoordinate) {
		setxCoordinate(xCoordinate);
		setyCoordinate(yCoordinate);
	}
	
	/** 
	 * @return a copy of this Position object.
	 */
	@Override
	public Position clone() {
		return new Position(getxCoordinate(), getyCoordinate());
	}
	
	
	/**
	 * Calculates the distance between two positions
	 * @param pos1
	 * 			The first position
	 * @param pos2
	 * 			The second position
	 * @return If both positions are effective, the Euclidean distance between them is returned.
	 * 			| Math.sqrt( (pos1.getxCoordinate() - pos2.getxCoordinate())^2 +
	 *			| 	(pos1.getyCoordinate() - pos2.getyCoordinate())^2 )
	 * @throws NullPointerException
	 * 			One of the positions is not effective
	 * 			| (pos1 == null) || (pos2 == null)
	 */
	public static double getDistanceBetween(Position pos1, Position pos2) throws NullPointerException {
		return Math.hypot(pos1.getxCoordinate() - pos2.getxCoordinate(),
				pos1.getyCoordinate() - pos2.getyCoordinate());
	}
}