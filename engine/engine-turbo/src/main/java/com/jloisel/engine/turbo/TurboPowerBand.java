package com.jloisel.engine.turbo;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.powerband.api.PowerBand;

/**
 * Turbo {@link PowerBand} have adjustable turbo pressure 
 * horsePower and torque curves.
 * 
 * {@link Turbo} have extra horse power and torque compared to 
 * atmospheric {@link PowerBand}. 
 *  
 * Not final for testing purpose.
 * 
 * @author Jerome
 *
 */
class TurboPowerBand implements PowerBand, Turbo {
	private final TurboHorsePower horsePower;
	private final TurboTorque torque;
	
	/**
	 * @param horsePower horse power curve
	 * @param torque torque curve
	 * @throws NullPointerException when any of the input parameter is {@code null}
	 */
	@Inject
	TurboPowerBand(final TurboHorsePower horsePower, final TurboTorque torque) {
		super();
		this.horsePower = checkNotNull(horsePower);
		this.torque = checkNotNull(torque);
	}

	@Override
	public TurboHorsePower horsePower() {
		return horsePower;
	}

	@Override
	public TurboTorque torque() {
		return torque;
	}

	@Override
	public void setPressure(final int pressure) {
		horsePower.setPressure(pressure);
		torque.setPressure(pressure);
	}
}
