package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterJsonLoader extends JsonParameterLoader implements JsonLoader<Step> {
    private static final Log log = getLog(JsonParameterJsonLoader.class);

	@Override
	public Step load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String jsonPath = jsonObject.getString(JSONPATH);
		String source = loadOptionalStr(jsonObject, SOURCE);
		String value = loadOptionalStr(jsonObject, VALUE);
		String file = loadOptionalStr(jsonObject, FILE);
		ValueProcessor processor = loadOptionalValueProcessor(jsonObject, allIds);
		return buildJsonParameter(loadId(jsonObject, allIds), loadPrototype(jsonObject), loadContext(jsonObject), source, value, file, processor, jsonPath, log);
	}
}
