package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.core.JsonConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class XmlParameterJsonLoader implements JsonLoader<Step> {
    private static final Log log = Log.getLog(XmlParameter.class);

	@Override
	public Step load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String xpath = jsonObject.getString(XPATH);
		Object namespaceObj = jsonObject.get(NAMESPACES);
		Map<String,String> namespaces = namespaceObj == null ? null : namespaceObj instanceof String ? loadNamespaces((String) namespaceObj, log) : loadNamespaces((JSONObject) namespaceObj);
		ValueProcessor processor = loadOptionalValueProcessor(jsonObject, allIds);
		String id = loadId(jsonObject, allIds);
		log.debug("Loaded xml parameter '" + id + "'");
		return new XmlParameter(id, loadPrototype(jsonObject), loadContext(jsonObject), loadContextLocation(jsonObject), new XPathProcessor(xpath, namespaces), processor);
	}
}
