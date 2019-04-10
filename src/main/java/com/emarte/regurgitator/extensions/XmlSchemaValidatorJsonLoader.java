/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.JsonLoader;
import com.emarte.regurgitator.core.Log;
import com.emarte.regurgitator.core.RegurgitatorException;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;
import static com.emarte.regurgitator.core.Log.getLog;

public class XmlSchemaValidatorJsonLoader implements JsonLoader<XmlSchemaValidator> {
    private static final Log log = getLog(XmlSchemaValidatorJsonLoader.class);

    @Override
    public XmlSchemaValidator load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xml schema validator");
        return new XmlSchemaValidator(loadMandatoryStr(jsonObject, FILE));
    }
}
