package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Sets;

public class TechnologyTest {

	@Test
	public void byArgument() {
		assertEquals(Technology.C, Technology.byArgument(Argument.TYPE_C));
		assertEquals(Technology.JS, Technology.byArgument(Argument.TYPE_JS));
		assertNull(Technology.byArgument(Argument.PATH));
	}

	@Test
	public void testFrom() {
		assertEquals(Technology.C, Technology.from(Sets.newHashSet()));
		assertEquals(Technology.JS, Technology.from(Sets.newHashSet(Argument.TYPE_JS)));
		assertEquals(Technology.C, Technology.from(Sets.newHashSet(Argument.TYPE_C)));
		Technology technology = Technology.from(Sets.newHashSet(Argument.TYPE_C, Argument.TYPE_JS));
		assertTrue(Technology.C.equals(technology) || Technology.JS.equals(technology));
	}
}