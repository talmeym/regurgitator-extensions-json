/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.ValueProcessor;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.CoreConfigConstants.VALUE;
import static uk.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static uk.emarte.regurgitator.core.Log.getLog;

public class VelocityProcessorJsonLoader extends VelocityProcessorLoader implements JsonLoader<ValueProcessor> {
    private static final Log log = getLog(VelocityProcessorJsonLoader.class);

    @Override
    public ValueProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        String value = loadOptionalStr(jsonObject, VALUE);
        String file = loadOptionalStr(jsonObject, FILE);
        return buildVelocityValueProcessor(value, file, log);
    }
}
