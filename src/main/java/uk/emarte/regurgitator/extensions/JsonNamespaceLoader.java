/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.Log;

import java.util.HashMap;
import java.util.Map;

import static uk.emarte.regurgitator.core.Log.getLog;

class JsonNamespaceLoader extends NamespaceLoader {
    private static final Log log = getLog(JsonNamespaceLoader.class);

    static Map<String, String> loadNamespaces(Object object) {
        return object == null ? new HashMap<>() : object instanceof String ? loadNamespaces((String) object, log) : loadNamespaces((JSONObject)object);
    }

    static Map<String, String> loadNamespaces(JSONObject jsonObject) {
        Map<String, String> namespaceMap = new HashMap<>();

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
