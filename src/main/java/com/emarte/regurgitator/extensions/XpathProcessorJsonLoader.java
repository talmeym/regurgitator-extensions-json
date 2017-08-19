package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class XpathProcessorJsonLoader implements JsonLoader<XpathProcessor> {
	private static final Log log = getLog(XpathProcessorJsonLoader.class);

	@Override
	public XpathProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded xpath processor");
		return new XpathProcessor(loadMandatoryStr(jsonObject, XPATH), loadNamespaces(jsonObject.get(NAMESPACES)));
	}
}
