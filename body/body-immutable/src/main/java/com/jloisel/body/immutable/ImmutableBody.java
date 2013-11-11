package com.jloisel.body.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.body.api.Body;
import com.jloisel.material.api.Material;

final class ImmutableBody implements Body {
	private final Material material;
	
	@Inject
	ImmutableBody(final Material material) {
		super();
		this.material = checkNotNull(material);
	}

	@Override
	public Material madeOf() {
		return material;
	}
}
