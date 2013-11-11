package com.jloisel.wheel.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.material.api.Material;
import com.jloisel.wheel.api.Wheel;
import com.jloisel.wheel.api.WheelSize;

/**
 * Immutable {@link Wheel}.
 * 
 * @author Jerome
 *
 */
final class ImmutableWheel implements Wheel {
	private final WheelSize size;
	private final Material material;
	
	@Inject
	ImmutableWheel(final WheelSize size, final Material material) {
		super();
		this.size = checkNotNull(size);
		this.material = checkNotNull(material);
	}

	@Override
	public WheelSize size() {
		return size;
	}

	@Override
	public Material madeOf() {
		return material;
	}
	
	@Override
	public String toString() {
		return "Wheel[size="+size+", material="+material+"]";
	}
}
