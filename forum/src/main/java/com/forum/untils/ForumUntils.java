package com.forum.untils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

public class ForumUntils {
	
	public static String getRandomUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	public static String toJsonString(Integer code) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		return json.toJSONString();
	}
	
	public static String toJsonString(Integer code,String message) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		return json.toJSONString();
	}
	
	public static String toJsonString(Integer code,Map<String,Object> map) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		Set<Entry<String, Object>> entrySet = map.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		return json.toJSONString();
	}

    public static String MD5(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
	
	
}
