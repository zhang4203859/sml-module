package org.hw.sml.component;

import org.hw.sml.queryplugin.JsonMapper;

import com.alibaba.fastjson.JSON;

public class RcptFastJsonMapper implements JsonMapper{
	public <T> T toObj(String json, Class<T> t) {
			return JSON.parseObject(json, t);
	}
	public String toJson(Object obj) {
			return JSON.toJSONString(obj);
	
	}
}