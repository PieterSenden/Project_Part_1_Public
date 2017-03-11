package asteroids.model;

/**
 * A class for signaling exceptions in positions.
 * 
 * @author Joris Ceulemans & Pieter Senden
 * @version 1.0
 */
public class IllegalPositionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initialize this new IllegalPositionException.
	 */
	public IllegalPositionException() {
		super();
	}
}
