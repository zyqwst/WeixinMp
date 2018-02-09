package com.albert.wechat.utils;

import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
public class JsonUtils {
  public static String toJson(Object obj) {
    return WxMpGsonBuilder.create().toJson(obj);
  }
  
  public static Map<String,String> fromJson(String json){
	  Gson gson = new GsonBuilder().enableComplexMapKeySerialization()  
			  .setDateFormat("yyyy-MM-dd")  
              .create();  
	  return gson.fromJson(json,  
              new TypeToken<Map<String, Object>>() {  
              }.getType());  
  }
  
}
