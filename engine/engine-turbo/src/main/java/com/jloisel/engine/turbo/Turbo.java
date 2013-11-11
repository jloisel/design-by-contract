package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.inject.Inject;

/**
 * Turbo increases linear coefficient to provide additionnal 
 * horse power and torque.
 * 
 * Turbo pressure is configured by annotation.
 * 
 * @author Jerome
 *
 */
final class Turbo {
	private final int pressure;
	
	@Inject
	Turbo(@TurboPressureValue final Integer pressure) {
		super();
		checkArgument(pressure > 0, "pressure must be a positive integer, invalid %s", pressure);
		this.pressure = pressure;
	}
	
	/**
	 * @return linear coefficient augmented by turbo pressure
	 */
	Integer pressurize(final Integer coefficient) {
		return pressure * coefficient;
	}
}
