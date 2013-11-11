package com.jloisel.engine.turbo;

/**
 * Implementing classes have adjustable turbo pressure.
 * 
 * @author Jerome
 *
 */
interface Turbo {
	/**
	 * Sets Turbo max pressure in PSI, atmospheric pressure 
	 * not included.
	 * 
	 * @param pressure turbo pressure in PSI
	 */
	void setPressure(int pressure);
}
