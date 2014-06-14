package timeout;

import timeout.service.Observable;
import timeout.service.PrintService;

public class Application {
	public static void main(String[] args) {
		Observable printService = PrintService.getInstance();
		printService.print1();
		printService.print2();
		
		try{
			System.out.println(printService.print10());
		}catch(NullPointerException e){
			System.err.println("null pointer exc");
		}
		System.out.println("normal working :)");
	}
}