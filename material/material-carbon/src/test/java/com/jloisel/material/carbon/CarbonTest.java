package com.jloisel.material.carbon;

import com.jloisel.material.api.AbstractMaterialTest;
import com.jloisel.material.api.Material;

public class CarbonTest extends AbstractMaterialTest {
	@Override
	protected Material newInstance() {
		return new Carbon();
	}
}
