package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.NamespaceLoader.loadNamespaces;

public class XPathProcessorJsonLoader implements JsonLoader<ValueProcessor> {
	private static final Log log = Log.getLog(XPathProcessorJsonLoader.class);

	@Override
	public XPathProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String xpath = jsonObject.getString(XPATH);
		Object namespaceObj = jsonObject.get(NAMESPACES);
		Map<String,String> namespaces =
				namespaceObj != null ? namespaceObj instanceof String ? loadNamespaces((String) namespaceObj, log) : JsonNamespaceLoader.loadNamespaces((JSONObject) namespaceObj) : null;
		log.debug("Loaded xpath processor");
		return new XPathProcessor(xpath, namespaces);
	}
}
