/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonPathProcessorJsonLoader implements JsonLoader<JsonPathProcessor> {
    private static final Log log = getLog(JsonPathProcessor.class);

    @Override
    public JsonPathProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded json path processor");
        return new JsonPathProcessor(jsonObject.getString(JSONPATH));
    }
}
