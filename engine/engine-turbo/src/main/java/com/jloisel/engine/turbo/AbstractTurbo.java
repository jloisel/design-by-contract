package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.jloisel.engine.turbo.TurboEngineModule.DEFAULT_PRESSURE;

import com.jloisel.powerband.api.curve.PowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

abstract class AbstractTurbo extends AbstractPowerCurve implements Turbo {
	private final PowerCurve curve;
	private int pressure = DEFAULT_PRESSURE;	
	
	protected AbstractTurbo(final PowerCurve curve) {
		super(curve.range());
		this.curve = checkNotNull(curve);
	}

	@Override
	protected Integer whenWithinRange(final Integer input) {
		return pressure * curve.apply(input);
	}

	@Override
	public void setPressure(final int pressure) {
		this.pressure = pressure;
	}
}
