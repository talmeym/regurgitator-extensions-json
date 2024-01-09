/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import net.sf.json.JSONObject;

import java.util.Set;

import static uk.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.XPATH;
import static uk.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class XpathProcessorJsonLoader implements JsonLoader<XpathProcessor> {
    private static final Log log = getLog(XpathProcessorJsonLoader.class);

    @Override
    public XpathProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        log.debug("Loaded xpath processor");
        return new XpathProcessor(loadMandatoryStr(jsonObject, XPATH), loadNamespaces(jsonObject.get(NAMESPACES)));
    }
}
