package com.test;

import com.test.service.Observable;
import com.test.service.PrintService;

public class Application {
	public static void main(String[] args) {
		Observable printService = PrintService.getInstance();
		printService.print1();
		printService.print2();
		
		System.out.println(printService.print10());
	}
}