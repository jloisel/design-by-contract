package com.jloisel.wheel.immutable;

import com.google.inject.PrivateModule;
import com.jloisel.material.api.Material;
import com.jloisel.wheel.api.Wheel;
import com.jloisel.wheel.api.WheelSize;

public final class ImmutableWheelModule extends PrivateModule {
	@Override
	protected void configure() {
		bind(Wheel.class).to(ImmutableWheel.class);
		
		requireBinding(WheelSize.class);
		requireBinding(Material.class);
		
		expose(Wheel.class);
	}
}
