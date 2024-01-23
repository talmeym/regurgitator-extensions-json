/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;

import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static uk.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;
import static uk.emarte.regurgitator.core.Log.getLog;

public class JsonSchemaValidatorJsonLoader implements JsonLoader<JsonSchemaValidator> {
    private static final Log log = getLog(JsonSchemaValidatorJsonLoader.class);

    @Override
    public JsonSchemaValidator load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded json schema validator");
        return new JsonSchemaValidator(loadMandatoryStr(jsonObject, FILE));
    }
}
