/**
 * 
 */
package com.tilioteo.common.collections;

import java.util.HashMap;

import com.tilioteo.common.Strings;

/**
 * @author kamil
 *
 */
@SuppressWarnings("serial")
public class StringMap extends HashMap<String, String> {

	public static final String STR_UNIT_PX						=	"px";
	public static final String STR_UNIT_PT						=	"pt";
	public static final String STR_UNIT_EM						=	"em";
	public static final String STR_UNIT_EX						=	"ex";
	public static final String STR_UNIT_MM						=	"mm";
	public static final String STR_UNIT_CM						=	"cm";
	public static final String STR_UNIT_PERCENT					=	"%";
	
	public static final String STR_COMMA						=	",";
	public static final String STR_QUOTED_STRING_SPLIT_PATTERN	=	"['']";

	public String get(String key, String defaultValue) {
		String value = get(key);
		return value != null ? value : defaultValue;
	}
	
	public String getDimension(String key) {
		String value = get(key);
		if (value != null &&
				!(value.endsWith(STR_UNIT_PX) ||
				value.endsWith(STR_UNIT_PT) ||
				value.endsWith(STR_UNIT_EM) ||
				value.endsWith(STR_UNIT_EX) ||
				value.endsWith(STR_UNIT_MM) ||
				value.endsWith(STR_UNIT_CM) ||
				value.endsWith(STR_UNIT_PERCENT))) {
			try {
				Double doubleValue = Double.parseDouble(value);
				value = doubleValue + STR_UNIT_PX;
			} catch (NumberFormatException e) {
				value = null;
			}
		}
		
		return value;
	}

	public Boolean getBoolean(String key) {
		String value = get(key);
		if (!Strings.isNullOrEmpty(value)) {
			return Boolean.parseBoolean(value);
		} else {
			return null;
		}
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		Boolean value = getBoolean(key);
		return value != null ? value : defaultValue;
	}

	public Integer getInteger(String key) {
		return Strings.toInteger(get(key));
	}

	public int getInteger(String key, int defaultValue) {
		Integer value = getInteger(key);
		return value != null ? value : defaultValue;
	}

	public Double getDouble(String key) {
		return Strings.toDouble(get(key));
	}

	public double getDouble(String key, double defaultValue) {
		Double value = getDouble(key);
		return value != null ? value : defaultValue;
	}
	
	public String[] getStringArray(String key) {
		return getStringArray(key, false);
	}
	
	public String[] getStringArray(String key, boolean emptyArrayAsDefault) {
		String[] array = Strings.toStringArray(get(key), STR_COMMA, STR_QUOTED_STRING_SPLIT_PATTERN);
		
		if (array != null) {
			return array;
		} else if (emptyArrayAsDefault)
			return new String[] {};
		else
			return null;
	}

}
