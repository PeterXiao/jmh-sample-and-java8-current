
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @BaseTestConfiguration.java
 * @Author Petershow@mem853.com
 * @Time 下午3:25:53
 */

package com.migua.tech.test;

import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * @Title:
 * @Description:
 * @Author:LiY
 * @Since:2018年9月27日
 * @Version:1.1.0
 */

public abstract class BaseTestConfiguration {
	@Rule
	public Timeout testTimeout = new Timeout(60000); // 60k ms = 1 minute
}
