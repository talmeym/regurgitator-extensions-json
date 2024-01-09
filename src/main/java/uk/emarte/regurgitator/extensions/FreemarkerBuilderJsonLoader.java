/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueBuilder;
import net.sf.json.JSONObject;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.JsonConfigUtil.loadOptionalBool;
import static uk.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class FreemarkerBuilderJsonLoader extends FreemarkerBuilderLoader implements JsonLoader<ValueBuilder> {
    private static final Log log = getLog(FreemarkerBuilderJsonLoader.class);

    @Override
    public ValueBuilder load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        String source = loadOptionalStr(jsonObject, SOURCE);
        String value = loadOptionalStr(jsonObject, VALUE);
        String file = loadOptionalStr(jsonObject, FILE);
        boolean allContexts = loadOptionalBool(jsonObject, ALL_CONTEXTS);
        return buildFreemarkerValueBuilder(source, value, file, allContexts, log);
    }
}
