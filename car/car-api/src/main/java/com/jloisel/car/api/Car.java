package com.jloisel.car.api;

import com.jloisel.powerband.api.PowerBand;

/**
 * Automotive car.
 * 
 * @author Jerome
 *
 */
public interface Car {

	/**
	 * Car {@link PowerBand} represents Car's power characteristics 
	 * like horsepower, torque.
	 * 
	 * @return car power band
	 */
	PowerBand powerBand();
}
