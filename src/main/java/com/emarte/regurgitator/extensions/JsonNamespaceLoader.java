/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import net.sf.json.JSONObject;

import java.util.*;

import static com.emarte.regurgitator.core.Log.getLog;

class JsonNamespaceLoader extends NamespaceLoader {
	private static final Log log = getLog(JsonNamespaceLoader.class);

	static Map<String, String> loadNamespaces(Object object) {
		return object == null ? null : object instanceof String ? loadNamespaces((String) object, log) : loadNamespaces((JSONObject)object);
	}

	static Map<String, String> loadNamespaces(JSONObject jsonObject) {
		Map<String, String> namespaceMap = new HashMap<String,  String>();

		for(Object key: jsonObject.keySet()) {
			String prefix = (String) key;
			String uri = jsonObject.getString(prefix);
			namespaceMap.put(prefix, uri);
			log.debug("Loaded namespace '{}={}'", prefix, uri);
		}

		log.debug("Loaded {} namespaces", namespaceMap.size());
		return namespaceMap;
	}
}
