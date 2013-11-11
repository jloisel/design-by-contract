package com.jloisel.material.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

public abstract class AbstractMaterialedTest {
	@Test
	public void shouldPassNPETester() {
		new NullPointerTester().testConstructors(newInstance().getClass(), PACKAGE);
	}
	
	@Test
	public void shouldReturnMadeOf() {
		assertNotNull(newInstance().madeOf());
	}
	
	protected abstract Materialed newInstance();
}
