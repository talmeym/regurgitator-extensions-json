package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;

import java.util.*;

public class ExtensionsJsonPackageMap extends AbstractJsonPackageMap {
	private static final List<String> kinds = Arrays.asList("freemarker-builder", "json-parameter", "contains-json-path", "contains-xpath");

	public ExtensionsJsonPackageMap() {
		addPackageMapping(kinds, "com.emarte.regurgitator.extensions");
	}
}
