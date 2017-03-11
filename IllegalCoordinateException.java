package asteroids.model;

/**
 * A class for signaling exceptions in coordinates of a position.
 * 
 * @author Joris Ceulemans & Pieter Senden
 * @version 1.0
 */
public class IllegalCoordinateException extends RuntimeException {
	
	public IllegalCoordinateException() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
}
