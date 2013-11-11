package com.jloisel.engine.api;

import com.jloisel.powerband.api.PowerBand;

/**
 * Car engine with specific power characteristics.
 * 
 * @author Jerome
 *
 */
public interface Engine {
	
	/**
	 * @return engine power band
	 */
	PowerBand powerBand();
}
