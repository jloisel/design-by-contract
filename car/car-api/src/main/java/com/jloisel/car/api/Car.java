package com.jloisel.car.api;

import com.jloisel.body.api.Body;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.wheel.api.Wheel;

/**
 * Automotive car.
 * 
 * @author Jerome
 *
 */
public interface Car {
	/**
	 * Car body.
	 * 
	 * @return car body
	 */
	Body body();
	
	/**
	 * Car is motioned by a four {@link Wheel}.
	 * 
	 * @return wheels in the following order: front left, front right
	 * rear left, rear right
	 */
	Iterable<Wheel> wheels();
	
	/**
	 * Car {@link PowerBand} represents Car's power characteristics 
	 * like horsepower, torque.
	 * 
	 * @return car power band
	 */
	PowerBand powerBand();
}
