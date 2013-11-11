package com.jloisel.body.immutable;

import com.google.inject.PrivateModule;
import com.jloisel.body.api.Body;
import com.jloisel.material.api.Material;

/**
 * <p>Provides {@link Body}.
 * <p>Requires {@link Material}.
 * 
 * @author Jerome
 *
 */
public final class ImmutableBodyModule extends PrivateModule {
	@Override
	protected void configure() {
		bind(Body.class).to(ImmutableBody.class);
		requireBinding(Material.class);
		expose(Body.class);
	}
}
