package com.jloisel.engine.electric;

import com.google.inject.PrivateModule;
import com.jloisel.engine.api.Engine;
import com.jloisel.engine.common.ImmutableEngineModule;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.constant.ConstantPowerBandModule;

/**
 * Provides an Electric {@link Engine}. This kind of {@link Engine}
 * delivers constant {@link PowerBand}.
 * 
 * See {@link ConstantPowerBandModule} for requirements.
 * 
 * @author Jerome
 *
 */
public final class ElectricEngineModule extends PrivateModule {

	@Override
	protected void configure() {
		install(new ImmutableEngineModule());
		install(new ConstantPowerBandModule());
		
		expose(Engine.class);
	}

}
