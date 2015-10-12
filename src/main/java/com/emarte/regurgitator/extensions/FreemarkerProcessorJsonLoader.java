package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;

public class FreemarkerProcessorJsonLoader extends FreemarkerProcessorLoader implements JsonLoader<ValueProcessor> {
	private static final Log log = Log.getLog(FreemarkerProcessorJsonLoader.class);

	@Override
	public ValueProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String value = loadOptionalStr(jsonObject, VALUE);
		String file = loadOptionalStr(jsonObject, FILE);
		return buildFreemarkerValueProcessor(value, file, log);
	}
}
