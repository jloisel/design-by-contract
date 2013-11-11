package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.jloisel.engine.turbo.TurboEngineModule.DEFAULT_PRESSURE;

import com.jloisel.powerband.api.curve.PowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

/**
 * Common {@link Turbo} {@link PowerCurve} implementations.
 * Methods not final for testing purpose.
 * 
 * @author Jerome
 *
 */
abstract class AbstractTurboPowerCurve extends AbstractPowerCurve implements Turbo {
	private final PowerCurve curve;
	private volatile int pressure = DEFAULT_PRESSURE;
	
	/**
	 * @param curve decorated power curve
	 * @throws NullPointerException when {@code curve} is {@code null}
	 */
	protected AbstractTurboPowerCurve(final PowerCurve curve) {
		super(checkNotNull(curve).range());
		this.curve = curve;
	}

	@Override
	protected synchronized Integer whenWithinRange(final Integer input) {
		return pressure * curve.apply(input);
	}

	@Override
	public synchronized void setPressure(final int pressure) {
		this.pressure = pressure;
	}
}
