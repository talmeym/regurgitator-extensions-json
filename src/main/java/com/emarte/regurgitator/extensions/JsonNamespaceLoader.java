package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.Log;
import net.sf.json.JSONObject;

import java.util.*;

public class JsonNamespaceLoader extends NamespaceLoader {
	private static Log log = Log.getLog(JsonNamespaceLoader.class);

	public static Map<String, String> loadNamespaces(JSONObject jsonObject) {
		Map<String, String> namespaceMap = new HashMap<String,  String>();

		for(Object key: jsonObject.keySet()) {
			String prefix = (String) key;
			String uri = jsonObject.getString(prefix);
			namespaceMap.put(prefix, uri);
			log.debug("Loaded namespace '" + prefix + "=" + uri + "'");
		}

		log.debug("Loaded " + namespaceMap.size() + " namespaces");
		return namespaceMap;
	}
}
