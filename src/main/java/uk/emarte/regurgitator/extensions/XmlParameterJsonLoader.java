/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.*;

import java.util.List;
import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.JsonConfigUtil.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static uk.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class XmlParameterJsonLoader extends XmlParameterLoader implements JsonLoader<Step> {
    private static final Log log = getLog(XmlParameter.class);

    @Override
    public Step load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        String xpath = jsonObject.getString(XPATH);
        String source = loadOptionalStr(jsonObject, SOURCE);
        String value = loadOptionalStr(jsonObject, VALUE);
        String file = loadOptionalStr(jsonObject, FILE);
        List<ValueProcessor> processors = loadOptionalValueProcessors(jsonObject, allIds);
        return buildXmlParameter(loadId(jsonObject, allIds), loadPrototype(jsonObject), loadContext(jsonObject), source, value, file, processors, new XpathProcessor(xpath, loadNamespaces(jsonObject.get(NAMESPACES))), log);
    }
}
