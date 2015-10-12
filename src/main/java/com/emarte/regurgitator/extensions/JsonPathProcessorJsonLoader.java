package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonPathProcessorJsonLoader implements JsonLoader<ValueProcessor> {
	private static final Log log = Log.getLog(JsonPathProcessor.class);

	@Override
	public JsonPathProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded json path processor");
		return new JsonPathProcessor(jsonObject.getString(JSONPATH));
	}
}
