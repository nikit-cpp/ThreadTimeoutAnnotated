package com.test.service;

import java.util.concurrent.TimeUnit;

import com.test.annotation.Timeout;
import com.test.annotation.processor.TimeoutProxy;

public class PrintService implements Observable {
	private static Observable instance;

	private PrintService() {

	}

	public static Observable getInstance() {
		if (instance == null) {
			instance = (Observable) TimeoutProxy.getNewProxy(
					new PrintService(), Observable.class); // собственно на этой строчке инстанцируется экземпляр.
		}
		return instance;
	}

	@Timeout(3)
	public void print1() {
		System.out.println("1 - Text in annotated method");
		System.out.println("print1: before sleep");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		System.out.println("print1: after sleep");

	}
	
	@Timeout(value=3000, units=TimeUnit.MILLISECONDS)
	public int print10() {
		System.out.println("print10: before sleep");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		System.out.println("stupid: after sleep");
		return 10;
	}

	public void print2() {
		System.out.println("2 - Just ususal text");
	}
}