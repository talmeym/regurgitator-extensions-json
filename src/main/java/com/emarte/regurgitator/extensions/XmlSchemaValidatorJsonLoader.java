package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;

public class XmlSchemaValidatorJsonLoader implements JsonLoader<ValueProcessor> {
	private static final Log log = Log.getLog(XmlSchemaValidatorJsonLoader.class);

	@Override
	public ValueProcessor load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded xml schema validator");
		return new XmlSchemaValidator(loadMandatoryStr(jsonObject, FILE));
	}
}
