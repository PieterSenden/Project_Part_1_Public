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
	
//	/**
//	 * Return the position of this ship.
//	 */
//	@Basic @Raw
//	public double[] getPosition() {
//		return this.position.clone();
//	}
//	
//	/**
//	 * Check whether the given position is a valid position for
//	 * any ship.
//	 *  
//	 * @param  position
//	 *         The position to check.
//	 * @return true if position has length 2 and both coordinates are finite numbers.
//	 * 			false if postition.length is not 2 or at least one coordinate is Nan or Double.POSITIVE_INFINTY or Double.NEGATIVE_INFINITY.
//	 *       	| result == (position.length == 2) && Double.isFinite(position[0]) && Double.isFinite(position[1])
//	*/
//	public static boolean isValidPosition(double[] position) {
//		return (position.length == 2) && Double.isFinite(position[0]) && Double.isFinite(position[1]);
//	}
//	
//	/**
//	 * Set the position of this ship to the given position.
//	 * 
//	 * @param  position
//	 *         The new position for this ship.
//	 * @post   The position of this new ship is equal to
//	 *         the given position.
//	 *       | new.getPosition() == position
//	 * @throws IllegalPositionException
//	 *         The given position is not a valid position for any ship.
//	 *       | ! isValidPosition(getPosition())
//	 */
//	@Raw
//	private void setPosition(double[] position) throws IllegalPositionException {
//		if (! isValidPosition(position))
//			throw new IllegalPositionException();
//		this.position = position.clone();
//	}
//	
//	/**
//	 * Variable registering the position of this ship.
//	 */
//	private double[] position;
}
