package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.powerband.api.PowerBand;

final class ImmutableTurboEngine implements TurboEngine {
	private final TurboPowerBand powerBand;
	
	/**
	 * @param powerBand engine {@link TurboPowerBand}
	 * @throws NullPointerException when {@code powerBand} is {@code null}
	 */
	@Inject
	ImmutableTurboEngine(final TurboPowerBand powerBand) {
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
