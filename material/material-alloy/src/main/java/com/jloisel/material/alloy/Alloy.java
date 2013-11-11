package com.jloisel.material.alloy;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jloisel.material.api.Material;

/**
 * Alloy {@link Material}.
 * 
 * @author Jerome
 *
 */
@Singleton
final class Alloy implements Material {
	@Inject
	Alloy() {
		
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
