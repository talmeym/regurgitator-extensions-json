/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.core.Log.getLog;

public class VelocityProcessorJsonLoader extends VelocityProcessorLoader implements JsonLoader<ValueProcessor> {
    private static final Log log = getLog(VelocityProcessorJsonLoader.class);

    @Override
    public ValueProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        String value = loadOptionalStr(jsonObject, VALUE);
        String file = loadOptionalStr(jsonObject, FILE);
        return buildVelocityValueProcessor(value, file, log);
    }
}
