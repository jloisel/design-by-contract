package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Turbo engine with modifiable Turbo Pressure.
 * 
 * {@link Turbo} {@link Engine} have extra horse power and torque compared to 
 * atmospheric {@link Engine}.
 * 
 * @author Jerome
 *
 */
final class TurboEngine implements Turbo, Engine {
	private final TurboPowerBand powerBand;
	
	/**
	 * @param powerBand engine {@link TurboPowerBand}
	 * @throws NullPointerException when {@code powerBand} is {@code null}
	 */
	@Inject
	TurboEngine(final TurboPowerBand powerBand) {
		this.powerBand = checkNotNull(powerBand);
	}
	
	@Override
	public PowerBand powerBand() {
		return powerBand;
	}

	@Override
	public void setPressure(final int pressure) {
		powerBand.setPressure(pressure);
	}
}
