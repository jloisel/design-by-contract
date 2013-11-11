package com.jloisel.material.carbon;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jloisel.material.api.Material;

@Singleton
final class Carbon implements Material {
	@Inject
	Carbon() { }
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
