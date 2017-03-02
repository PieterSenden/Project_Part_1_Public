package asteroids.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class representing the velocity of a ship.
 * 
 * @author Joris & Pieter
 * @version 1.0
 * 
 * @invar  The xComponent of each velocity must be a valid xComponent for any velocity.
 *       | isValidxComponent(getxComponent())
 * @invar  The yComponent of each velocity must be a valid yComponent for any velocity.
 *       | isValidyComponent(getyComponent())
 */

public class Velocity {

	/**
	 * Initialize this new velocity with given xComponent and yComponent.
	 *
	 * @param  xComponent
	 *         The xComponent for this new velocity.
	 * @param  yComponent
	 *         The yComponent for this new velocity.
	 * @effect The xComponent of this new velocity is set to the given xComponent.
	 *       | this.setxComponent(xComponent)
	 * @effect The yComponent of this new velocity is set to the given yComponent.
	 *       | this.setyComponent(yComponent)
	 */
	public Velocity(double xComponent, double yComponent) {
		this.setxComponent(xComponent);
		this.setyComponent(yComponent);
	}
	
	
	/**
	 * Return the xComponent of this velocity.
	 */
	@Basic @Raw
	public double getxComponent() {
		return this.xComponent;
	}
	
	/**
	 * Check whether the given Component is a valid Component for any velocity.
	 *  
	 * @param  Component
	 *         The Component to check.
	 * @return true iff the given Component is a finite number.
	 *       | result == Double.isFinite(Component)
	*/
	public static boolean isValidComponent(double Component) {
		return Double.isFinite(Component);
	}
	
	/**
	 * Set the xComponent of this velocity to the given xComponent.
	 * 
	 * @param  xComponent
	 *         The new xComponent for this velocity.
	 * @post   If the given xComponent is valid, the xComponent of this new velocity is equal to the given xComponent.
	 *       | if (isValidComponent(xComponent))
	 *       |		then new.getxComponent() == xComponent
	 */
	@Raw
	public void setxComponent(double xComponent) {
		if (isValidComponent(xComponent))
			this.xComponent = xComponent;
	}
	
	/**
	 * Variable registering the xComponent of this velocity.
	 */
	private double xComponent = 0;
	
	
	/**
	 * Return the yComponent of this velocity.
	 */
	@Basic @Raw
	public double getyComponent() {
		return this.yComponent;
	}
	
	/**
	 * Set the yComponent of this velocity to the given yComponent.
	 * 
	 * @param  yComponent
	 *         The new yComponent for this velocity.
	 * @post   If the given yComponent is valid, the yComponent of this new velocity is equal to the given yComponent.
	 *       | if (isValidComponent(yComponent))
	 *       |		then new.getyComponent() == yComponent
	 */
	@Raw
	public void setyComponent(double yComponent) {
		if (isValidComponent(yComponent))
			this.yComponent = yComponent;
	}
	
	/**
	 * Variable registering the yComponent of this velocity.
	 */
	private double yComponent = 0;
	
	
	public void setVelocity(double xComponent, double yComponent) {
		setxComponent(xComponent);
		setyComponent(yComponent);
	}
	
	/** 
	 * @return a copy of this Velocity object.
	 */
	@Override
	public Velocity clone() {
		return new Velocity(getxComponent(), getyComponent());
	}
	
	
//	/**
//	 * Initialize this new ship with given velocity.
//	 * 
//	 * @param  velocity
//	 *         The velocity for this new ship.
//	 * @effect 
//	 * 			| this.setVelocity(velocity)
//	 */
//		
//	/**
//	 * Return the velocity of this ship.
//	 */
//	@Basic @Raw
//	public double[] getVelocity() {
//		return this.velocity.clone();
//	}
//	
//	/**
//	 * Check whether the given velocity is a valid velocity for
//	 * this ship.
//	 *  
//	 * @param  velocity
//	 *         The velocity to check.
//	 * @return True if and only if speed associated to the given velocity is less than or equal to the speed limit of this ship
//	 *       | result == Math.hypot(velocity[0], velocity[1]) <= getSpeedLimit()
//	*/
//	public boolean isValidVelocity(double[] velocity) {
//		return Math.hypot(velocity[0], velocity[1]) <= getSpeedLimit();
//	}
//	
//	/**
//	 * Set the velocity of this ship to the given velocity.
//	 * 
//	 * @param  velocity
//	 *         The new velocity for this ship.
//	 * @post   If the given velocity is a valid velocity for this ship,
//	 *         the velocity of this new ship is equal to the given
//	 *         velocity.
//	 *       	| if (isValidVelocity(velocity))
//	 *       	|   then new.getVelocity() == velocity
//	 * @post	If the given velocity is not a valid velocity for this ship,
//	 * 			the velocity is reduced such that the speed equals the speed limit of this ship,
//	 * 			but the direction of the velocity is left unchanged.
//	 * 			| if (!isValidVelocity(velocity))
//	 * 			|	then new.getVelocity() == velocity * getSpeedLimit() / Math.hypot(velocity[0], velocity[1]);
//	 */
//	@Raw @Model
//	private void setVelocity(double[] velocity) {
//		if (isValidVelocity(velocity))
//			this.velocity = velocity.clone();
//		else{
//			double speed = Math.hypot(velocity[0], velocity[1]);
//			velocity[0] = velocity[0] * getSpeedLimit() / speed;
//			velocity[1] = velocity[1] * getSpeedLimit() / speed;
//			setVelocity(velocity);
//		}
//	}
//	
//  
////		if (! canHaveAsSpeedLimit(speedLimit))
////			speedLimit = SPEED_OF_LIGHT;
////		this.speedLimit = speedLimit;
////	}
//	
//	
}
