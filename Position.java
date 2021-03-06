package asteroids.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class representing the position of a ship.
 * 
 * @author Joris Ceulemans & Pieter Senden
 * @version 1.0
 * 
 * @invar  The xCoordinate of each position must be a valid xCoordinate for any position.
 *       | isValidCoordinate(getxCoordinate())
 * @invar  The yCoordinate of each position must be a valid yCoordinate for any position.
 *       | isValidCoordinate(getyCoordinate())
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
	 * Check whether the given coordinate is a valid coordinate for any position.
	 *  
	 * @param  coordinate
	 *         The coordinate to check.
	 * @return true iff the given coordinate is a finite number.
	 *       | result == Double.isFinite(coordinate)
	*/
	public static boolean isValidCoordinate(double coordinate) {
		return Double.isFinite(coordinate);
	}
	
	/**
	 * Set the xCoordinate of this position to the given xCoordinate.
	 * 
	 * @param  xCoordinate
	 *         The new xCoordinate for this position.
	 * @post   The xCoordinate of this new position is equal to the given xCoordinate.
	 *       | new.getxCoordinate() == xCoordinate
	 * @throws IllegalCoordinateException
	 *         The given xCoordinate is not a valid coordinate for any position.
	 *       | ! isValidCoordinate(getxCoordinate())
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
	 *         The given yCoordinate is not a valid coordinate for any position.
	 *       | ! isValidCoordinate(getyCoordinate())
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
	 * Generate a copy of this Position object
	 * @return a copy of this Position object.
	 */
	@Override
	public Position clone() {
		return new Position(getxCoordinate(), getyCoordinate());
	}
	
	/**
	 * Return the position an array of length 2, with the position
	 * along the X-axis at index 0 and the position along the Y-axis at index 1. 
	 * @return  an array of length 2, with the position
	 * 			along the X-axis at index 0 and the position along the Y-axis at index 1.
	 * 			| result == new double[] {getxCoordinate(), getyCoordinate()}
	 */
	public double[] getAsArray() {
		return new double[] {getxCoordinate(), getyCoordinate()};
	}
	
	
	/**
	 * Calculates the distance between two positions
	 * @param pos1
	 * 			The first position
	 * @param pos2
	 * 			The second position
	 * @return If both positions are effective, the Euclidean distance between them is returned.
	 * 			| result == Math.sqrt( (pos1.getxCoordinate() - pos2.getxCoordinate())^2 +
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
