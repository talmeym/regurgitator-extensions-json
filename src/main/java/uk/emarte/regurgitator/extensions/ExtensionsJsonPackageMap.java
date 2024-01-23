/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import uk.emarte.regurgitator.core.AbstractJsonPackageMap;

import java.util.Arrays;
import java.util.List;

public class ExtensionsJsonPackageMap extends AbstractJsonPackageMap {
    private static final List<String> kinds = Arrays.asList("freemarker-builder", "freemarker-processor", "xml-parameter", "json-parameter", "contains-json-path", "contains-xpath", "xpath-processor", "json-path-processor", "json-print-processor", "xml-schema-validator", "json-schema-validator");

    public ExtensionsJsonPackageMap() {
        addPackageMapping(kinds, "uk.emarte.regurgitator.extensions");
    }
}
