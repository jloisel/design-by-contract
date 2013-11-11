package com.jloisel.wheel.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WheelSizeTest {

	@Test
	public void shouldPass() {
		for(final WheelSize size : WheelSize.values()) {
			assertNotNull(size);
		}
	}
}
