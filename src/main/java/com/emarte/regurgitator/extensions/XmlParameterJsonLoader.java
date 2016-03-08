package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class XmlParameterJsonLoader extends XmlParameterLoader implements JsonLoader<Step> {
    private static final Log log = Log.getLog(XmlParameter.class);

	@Override
	public Step load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String xpath = jsonObject.getString(XPATH);
		String source = loadOptionalStr(jsonObject, SOURCE);
		String value = loadOptionalStr(jsonObject, VALUE);
		String file = loadOptionalStr(jsonObject, FILE);
		ValueProcessor processor = loadOptionalValueProcessor(jsonObject, allIds);
		return buildXmlParameter(loadId(jsonObject, allIds), loadPrototype(jsonObject), loadContext(jsonObject), source, value, file, processor, new XpathProcessor(xpath, loadNamespaces(jsonObject.get(NAMESPACES))), log);
	}
}
