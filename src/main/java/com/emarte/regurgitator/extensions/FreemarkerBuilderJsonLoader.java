package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;

public class FreemarkerBuilderJsonLoader extends FreemarkerBuilderLoader implements JsonLoader<ValueBuilder> {
	private static final Log log = Log.getLog(FreemarkerBuilderJsonLoader.class);

	@Override
	public ValueBuilder load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		String source = loadOptionalStr(jsonObject, SOURCE);
		String value = loadOptionalStr(jsonObject, VALUE);
		String file = loadOptionalStr(jsonObject, FILE);
		return buildFreemarkerValueBuilder(source, value, file, log);
	}
}
