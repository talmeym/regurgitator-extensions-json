/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.AbstractJsonPackageMap;

import java.util.*;

public class ExtensionsJsonPackageMap extends AbstractJsonPackageMap {
	private static final List<String> kinds = Arrays.asList("freemarker-builder", "freemarker-processor", "velocity-builder", "velocity-processor", "xml-parameter", "json-parameter", "contains-json-path", "contains-xpath", "xpath-processor", "json-path-processor", "xml-schema-validator");

	public ExtensionsJsonPackageMap() {
		addPackageMapping(kinds, "com.emarte.regurgitator.extensions");
	}
}
