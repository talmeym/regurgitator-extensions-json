package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class ContainsXpathJsonLoader implements JsonLoader<ConditionBehaviour> {
	private static final Log log = Log.getLog(ContainsXpathJsonLoader.class);

	@Override
	public ConditionBehaviour load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		Object namespaceObj = jsonObject.get(NAMESPACES);
		Map<String,String> namespaces =
				namespaceObj != null ? namespaceObj instanceof String ? loadNamespaces((String) namespaceObj, log) : loadNamespaces((JSONObject) namespaceObj) : null;
		log.debug("Loaded ContainsXpath");
		return new ContainsXpath(namespaces);
	}
}
