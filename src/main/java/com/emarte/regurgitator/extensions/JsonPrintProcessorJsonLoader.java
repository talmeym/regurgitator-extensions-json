/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.JsonLoader;
import com.emarte.regurgitator.core.Log;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;

public class JsonPrintProcessorJsonLoader implements JsonLoader<JsonPrintProcessor> {
    private static final Log log = getLog(JsonPrintProcessorJsonLoader.class);

    @Override
    public JsonPrintProcessor load(JSONObject jsonObject, Set<Object> allIds) {
        log.debug("Loaded json print processor");
        return new JsonPrintProcessor();
    }
}
