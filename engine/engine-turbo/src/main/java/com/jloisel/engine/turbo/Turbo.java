package com.jloisel.engine.turbo;

interface Turbo {
	/**
	 * Sets Turbo max pressure in PSI, atmospheric pressure 
	 * must not be included.
	 * 
	 * @param pressure turbo pressure in PSI
	 */
	void setPressure(int pressure);
}
