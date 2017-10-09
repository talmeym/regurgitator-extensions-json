/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class ContainsXpathJsonLoader implements JsonLoader<ContainsXpath> {
	private static final Log log = getLog(ContainsXpathJsonLoader.class);

	@Override
	public ContainsXpath load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded contains xpath");
		return new ContainsXpath(loadNamespaces(jsonObject.get(NAMESPACES)));
	}
}
