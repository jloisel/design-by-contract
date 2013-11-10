package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.powerband.api.PowerBand;

/**
 * Not final for testing purpose.
 * 
 * @author Jerome
 *
 */
class TurboPowerBand implements PowerBand, Turbo {
	private final TurboHorsePower horsePower;
	private final TurboTorque torque;
	
	@Inject
	TurboPowerBand(final TurboHorsePower horsePower, final TurboTorque torque) {
		super();
		this.horsePower = checkNotNull(horsePower);
		this.torque = checkNotNull(torque);
	}

	@Override
	public synchronized TurboHorsePower horsePower() {
		return horsePower;
	}

	@Override
	public synchronized TurboTorque torque() {
		return torque;
	}

	@Override
	public synchronized void setPressure(final int pressure) {
		horsePower.setPressure(pressure);
		torque.setPressure(pressure);
	}

	@Override
	public String toString() {
		return "TurboPowerBand=[HP="+horsePower + ", torque=" + torque + "]";
	}
}
