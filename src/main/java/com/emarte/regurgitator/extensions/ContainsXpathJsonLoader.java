package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class ContainsXpathJsonLoader implements JsonLoader<ContainsXpath> {
	private static final Log log = Log.getLog(ContainsXpathJsonLoader.class);

	@Override
	public ContainsXpath load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded ContainsXpath");
		return new ContainsXpath(loadNamespaces(jsonObject.get(NAMESPACES)));
	}
}
