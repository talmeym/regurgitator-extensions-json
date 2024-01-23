/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;

import java.util.Set;

import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static uk.emarte.regurgitator.extensions.JsonNamespaceLoader.loadNamespaces;

public class ContainsXpathJsonLoader implements JsonLoader<ContainsXpathBehaviour> {
    private static final Log log = getLog(ContainsXpathJsonLoader.class);

    @Override
    public ContainsXpathBehaviour load(JSONObject jsonObject, Set<Object> allIds) {
        log.debug("Loaded contains xpath");
        return new ContainsXpathBehaviour(loadNamespaces(jsonObject.get(NAMESPACES)));
    }
}
