package com.jloisel.material.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

public abstract class AbstractMaterialTest {

	@Test
	public void shouldPassNPETester() {
		new NullPointerTester().testConstructors(newInstance().getClass(), PACKAGE);
	}
	
	protected abstract Material newInstance();
}
