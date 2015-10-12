package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterJsonLoader implements JsonLoader<Step> {
    private static final Log log = Log.getLog(JsonParameterJsonLoader.class);

	@Override
	public Step load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String jsonPath = jsonObject.getString(JSONPATH);
		ValueProcessor processor = loadOptionalValueProcessor(jsonObject, allIds);
		String id = loadId(jsonObject, allIds);
		log.debug("Loaded json parameter '" + id + '\'');
		return new JsonParameter(id, loadPrototype(jsonObject), loadContext(jsonObject), loadContextLocation(jsonObject), new JsonPathProcessor(jsonPath), processor);
	}
}
