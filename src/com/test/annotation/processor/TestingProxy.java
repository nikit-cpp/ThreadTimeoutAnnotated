package com.test.annotation.processor;

import java.lang.reflect.Proxy;

public class TestingProxy {

	public static Object getNewProxy(Object proxied, Class<?> interfaze) {
		Object proxy = Proxy.newProxyInstance(
				TestingInvocationHandler.class.getClassLoader(),
				new Class[] { interfaze },
				new TestingInvocationHandler(proxied));
		return proxy;
	}

}