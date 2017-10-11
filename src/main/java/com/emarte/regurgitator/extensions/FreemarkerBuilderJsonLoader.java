/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalBoolean;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class FreemarkerBuilderJsonLoader extends FreemarkerBuilderLoader implements JsonLoader<ValueBuilder> {
    private static final Log log = getLog(FreemarkerBuilderJsonLoader.class);

    @Override
    public ValueBuilder load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        String source = loadOptionalStr(jsonObject, SOURCE);
        String value = loadOptionalStr(jsonObject, VALUE);
        String file = loadOptionalStr(jsonObject, FILE);
        boolean allContexts = loadOptionalBoolean(jsonObject, ALL_CONTEXTS);
        return buildFreemarkerValueBuilder(source, value, file, allContexts, log);
    }
}
