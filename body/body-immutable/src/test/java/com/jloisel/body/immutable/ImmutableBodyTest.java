package com.jloisel.body.immutable;

import static org.mockito.Mockito.mock;

import com.jloisel.body.api.AbstractBodyTest;
import com.jloisel.body.api.Body;
import com.jloisel.material.api.Material;

public class ImmutableBodyTest extends AbstractBodyTest {
	@Override
	protected Body newInstance() {
		return new ImmutableBody(mock(Material.class));
	}

}
