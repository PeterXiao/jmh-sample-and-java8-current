
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @Singleton.java
 * @Author Petershow@mem853.com
 * @Time 下午4:18:59
 */

package com.migua.tech.test;

import java.util.Scanner;

/**
 * @Title:
 * @Description:
 * @Author:LiY
 * @Since:2018年9月20日
 * @Version:1.1.0
 */

public class Singleton {
	private Singleton() {
	}

	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}

	private static class SingletonHolder {
		private static final Singleton instance = new Singleton();
	}

	public static void dmain(String[] args) {
		System.out.println("请输入内容：");
		Scanner scan = new Scanner(System.in); // 创建对象
		double i = scan.nextDouble(); // 定义变量（double类型）
		System.out.println("你刚才输入的内容是：" + i);
	}

}
