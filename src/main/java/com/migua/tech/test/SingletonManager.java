
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @SingletonManager.java
 * @Author Petershow@mem853.com
 * @Time 下午4:19:35
 */

package com.migua.tech.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Description:
 * @Author:LiY
 * @Since:2018年9月20日
 * @Version:1.1.0
 */

public class SingletonManager {
	private static Map<String, Object> objectMap = new HashMap<String, Object>();

	private SingletonManager() {
	}

	public static void putInstance(String key, Object instance) {
		if (!SingletonManager.objectMap.containsKey(key)) {
			SingletonManager.objectMap.put(key, instance);
		}
	}

	public static Object getInstance(String key) {
		return SingletonManager.objectMap.get(key);
	}
}
