package com.jloisel.engine.immutable;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;


final class AtmosphericEngine implements Engine {
	private final PowerBand powerBand;

	@Inject
	AtmosphericEngine(final PowerBand powerBand) {
		super();
		this.powerBand = checkNotNull(powerBand);
	}

	@Override
	public PowerBand powerBand() {
		return powerBand;
	}
	
	@Override
	public String toString() {
		return "Engine with PowerBand=["+powerBand+"]";
	}
}
